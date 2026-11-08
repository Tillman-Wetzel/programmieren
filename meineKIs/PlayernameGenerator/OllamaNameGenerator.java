import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OllamaNameGenerator {

    private static final String MODEL = "qwen2.5:7b";
    private static final String JSON_DATEI = "meineKI's/PlayernameGenerator/usedNames.json";

    public static void main(String[] args) {

        try {

            ArrayList<String> namen =
                    generiereNamen();

            System.out.println(
                    "Generierte Minecraft-Namen:"
            );

            for (String name : namen) {
                System.out.println("- " + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<String> generiereNamen() throws Exception {

        // Bereits verwendete Namen laden
        Set<String> usedNames = ladeBlacklist();


        String prompt = """
                Generate exactly 25 unique Minecraft Java player names.

                Rules:
                - 3 to 16 characters
                - Only A-Z, a-z, 0-9 and _
                - No spaces
                - No special characters
                - Every name must be unique

                Return ONLY valid JSON:

                {
                  "namen": [
                    "Name1",
                    "Name2",
                    "Name3"
                  ]
                }
                """;


        String json = """
                {
                    "model": "%s",
                    "stream": false,
                    "format": "json",
                    "prompt": "%s"
                }
                """.formatted(
                MODEL,
                escapeJson(prompt)
        );


        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(
                        "http://localhost:11434/api/generate"
                ))
                .header(
                        "Content-Type",
                        "application/json"
                )
                .POST(
                        HttpRequest.BodyPublishers.ofString(json)
                )
                .build();


        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );


        if (response.statusCode() != 200) {
            throw new IOException(
                    "Ollama Fehler: HTTP "
                            + response.statusCode()
            );
        }


        String ollamaResponse = response.body();


        // Ollama "response" auslesen
        Pattern responsePattern = Pattern.compile(
                "\"response\"\\s*:\\s*\"(.*?)\"\\s*,\\s*\"done\"",
                Pattern.DOTALL
        );


        Matcher responseMatcher =
                responsePattern.matcher(ollamaResponse);


        if (!responseMatcher.find()) {
            throw new IOException(
                    "Keine Antwort von Ollama gefunden."
            );
        }


        String kiJson =
                responseMatcher.group(1);


        // JSON-Escapes entfernen
        kiJson = kiJson
                .replace("\\n", "")
                .replace("\\\"", "\"")
                .replace("\\\\", "\\");


        // namen-Array finden
        Pattern namenPattern = Pattern.compile(
                "\"namen\"\\s*:\\s*\\[(.*?)\\]",
                Pattern.DOTALL
        );


        Matcher namenMatcher =
                namenPattern.matcher(kiJson);


        if (!namenMatcher.find()) {
            throw new IOException(
                    "Kein 'namen'-Array gefunden."
            );
        }


        String namenBlock =
                namenMatcher.group(1);


        // Nur gültige Minecraft-Namen erkennen
        Pattern namePattern = Pattern.compile(
                "\"([A-Za-z0-9_]{3,16})\""
        );


        Matcher nameMatcher =
                namePattern.matcher(namenBlock);


        ArrayList<String> ergebnis =
                new ArrayList<>();


        while (nameMatcher.find()) {

            String name =
                    nameMatcher.group(1);


            // Bereits verwendeten Namen überspringen
            if (usedNames.contains(
                    name.toLowerCase()
            )) {
                continue;
            }


            // Doppelte Namen verhindern
            if (ergebnis.stream()
                    .anyMatch(
                            n -> n.equalsIgnoreCase(name)
                    )) {
                continue;
            }


            ergebnis.add(name);


            if (ergebnis.size() == 25) {
                break;
            }
        }


        /*
         * WICHTIG:
         * Alle erfolgreich generierten Namen
         * werden zur Blacklist hinzugefügt.
         */
        for (String name : ergebnis) {
            usedNames.add(
                    name.toLowerCase()
            );
        }


        // Blacklist speichern
        speichereBlacklist(usedNames);


        return ergebnis;
    }


    private static Set<String> ladeBlacklist()
            throws IOException {

        Set<String> usedNames =
                new HashSet<>();


        Path datei = Path.of(JSON_DATEI).toAbsolutePath();

System.out.println("Ich suche usedNames.json hier:");
System.out.println(datei);


        // Datei existiert noch nicht
        if (!Files.exists(datei)) {

            // Leere JSON-Datei erstellen
            Files.writeString(
                    datei,
                    "{\n  \"namen\": []\n}"
            );

            return usedNames;
        }


        String json =
                Files.readString(datei);


        Pattern pattern = Pattern.compile(
                "\"([A-Za-z0-9_]{3,16})\""
        );


        Matcher matcher =
                pattern.matcher(json);


        while (matcher.find()) {

            usedNames.add(
                    matcher.group(1).toLowerCase()
            );
        }


        return usedNames;
    }


    private static void speichereBlacklist(
            Set<String> usedNames
    ) throws IOException {

        StringBuilder json =
                new StringBuilder();


        json.append("{\n");
        json.append("  \"namen\": [\n");


        int index = 0;


        for (String name : usedNames) {

            json.append("    \"")
                    .append(name)
                    .append("\"");


            if (index < usedNames.size() - 1) {
                json.append(",");
            }


            json.append("\n");


            index++;
        }


        json.append("  ]\n");
        json.append("}");


        Files.writeString(
                Path.of(JSON_DATEI),
                json.toString()
        );
    }


    private static String escapeJson(
            String text
    ) {

        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}