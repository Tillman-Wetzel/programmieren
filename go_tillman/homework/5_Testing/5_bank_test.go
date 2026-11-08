package main

import (
	"errors"
	"testing"
)

// Aufgabe 4: Table-driven Test für withdraw
//
// Testfälle:
//   - valid:        balance 100,  amount 50   -> kein Fehler
//   - negative:     balance 100,  amount -20  -> Fehler
//   - insufficient: balance 100,  amount 150  -> Fehler
//   - limit:        balance 2000, amount 1500 -> Fehler
//
// Tipp: Gib deiner Tabelle ein Feld wantErr bool.
func TestWithdraw(t *testing.T) {
	tests := []struct {
		name       string
		balance    int
		amount     int
		wantErr    bool
		wantReason string
	}{
		{"valid", 100, 50, false, ""},
		{"negative", 100, -20, true, "WithdrawalError"},
		{"insufficient", 100, 150, true, "WithdrawalError"},
		{"limit", 2000, 1500, true, "WithdrawalError"},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			err := withdraw(tt.balance, tt.amount)
			// TODO: prüfen, ob ein Fehler kam, wenn einer erwartet wurde
			//       (und keiner, wenn keiner erwartet wurde)

			if !tt.wantErr && err != nil {
				t.Fatalf("unexpected error: %v", err)
			}

			if err == nil && tt.wantErr {
				t.Fatalf("No Error, even though an Error was expected.")
			}

			if errors.As(err, &tt.wantReason) {
				t.Fatalf("Want error %v, got %v", tt.wantReason, err)
			}

			if !tt.wantErr {
				return // Happy Path: hier gibt es nichts mehr zu prüfen
			}

			// Aufgabe 4: kam ein Fehler, wenn einer erwartet war?
			if tt.wantErr && err == nil {
				t.Fatal("expected an error, got nil")
			}
			if !tt.wantErr && err != nil {
				t.Fatalf("unexpected error: %v", err)
			}
			if !tt.wantErr {
				return // Happy Path: hier gibt es nichts mehr zu prüfen
			}

		})
	}

}

// Aufgabe 6: Starte go test -cover.
// Welche Zeilen sind noch rot und warum? (go test -coverprofile=cover.out
// und go tool cover -html=cover.out helfen dir dabei)
