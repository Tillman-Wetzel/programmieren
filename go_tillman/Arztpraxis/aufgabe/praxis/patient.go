package praxis

type Patient struct {
	kvNummer string
	name     string
	vorname  string
}

func NewPatient(kvNummer, name, vorname string) Patient {
	return Patient{
		kvNummer: kvNummer,
		name:     name,
		vorname:  vorname,
	}
}

func (p Patient) GetKvNummer() string {
	return p.kvNummer
}

func (p Patient) GetName() string {
	return p.name
}

func (p Patient) GetVorname() string {
	return p.vorname
}
