package praxis

type Behandlung interface {
	KVNummer() string
	Beschreibung() string
	Kostensatz() float64
	GetKosten() float64
}

type basis struct {
	kvNummer     string
	beschreibung string
	kostensatz   float64
}

func (bb basis) KVNummer() string {
	return bb.kvNummer
}

func (bb basis) Beschreibung() string {
	return bb.beschreibung
}

func (bb basis) Kostensatz() float64 {
	return bb.kostensatz
}

type StandertBehandlung struct {
	basis
}

func (sb StandertBehandlung) GetKosten() float64 {
	return sb.kostensatz
}

func NewStandertBehandlung(kvNummer string, beschreibung string, kostensatz float64) StandertBehandlung {
	return StandertBehandlung{
		basis{kvNummer: kvNummer, beschreibung: beschreibung, kostensatz: kostensatz},
	}
}

type PhysioBehandlung struct {
	basis
}

func (pb PhysioBehandlung) GetKosten() float64 {
	return pb.kostensatz * 1.5
}

func NewPhysioBehandlung(kvNummer string, beschreibung string, kostensatz float64) PhysioBehandlung {
	return PhysioBehandlung{
		basis{kvNummer: kvNummer, beschreibung: beschreibung, kostensatz: kostensatz},
	}
}
