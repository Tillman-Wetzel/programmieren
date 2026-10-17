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
		{"valid", 100, 50, false, "WithdrawalError"},
		{"negative", 100, -20, true, "WithdrawalError"},
		{"insufficient", 100, 150, true, "WithdrawalError"},
		{"limit", 2000, 1500, true, "WithdrawalError"},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			err := withdraw(tt.balance, tt.amount)
			// TODO: prüfen, ob ein Fehler kam, wenn einer erwartet wurde
			//       (und keiner, wenn keiner erwartet wurde)

			if err != nil {
				if !tt.wantErr {
					t.Fatalf("unexpected error: %v", err)
				} else {
					if errors.As(err, &tt.wantReason) {
						t.Fatalf("Want error %v, got %v", tt.wantReason, err)
					}
				}

			} else if err == nil && tt.wantErr {
				t.Fatalf("No Error, even though an Error was expected.")

			}

		})
	}
}

// Aufgabe 5 (Bonus): Prüfe mit errors.As, dass Reason stimmt.
// Tipp: Ergänze in der Tabelle ein Feld wantReason string.

// Aufgabe 6: Starte go test -cover.
// Welche Zeilen sind noch rot und warum? (go test -coverprofile=cover.out
// und go tool cover -html=cover.out helfen dir dabei)
