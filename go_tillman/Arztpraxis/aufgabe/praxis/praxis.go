package praxis

type Praxis struct {
	name         string
	patienten    []Patient
	behandlungen []Behandlung
}

func NewPraxis(name string) *Praxis {
	return &Praxis{name: name}
}

func (p *Praxis) AddPatient(pat Patient) {
	p.patienten = append(p.patienten, pat)
}

func (p *Praxis) AddBehandlung(b Behandlung) {
	p.behandlungen = append(p.behandlungen, b)
}

func (p *Praxis) GetPatient(name string) []Patient {
	patienten := []Patient{}
	for _, patient := range p.patienten {
		if patient.GetName() == name {
			patienten = append(patienten, patient)
		}
	}

	return patienten
}

func (p *Praxis) GetBehandlung(kvNummer string) []Behandlung {
	behandlungen := []Behandlung{}
	for _, behandlung := range p.behandlungen {
		if behandlung.KVNummer() == kvNummer {
			behandlungen = append(behandlungen, behandlung)
		}
	}

	return behandlungen
}

func (p Praxis) AnzBehandlungen() int {
	return len(p.behandlungen)
}

func (p Praxis) ErmittleKosten() float64 {
	var kosten float64 = 0

	for _, behandlung := range p.behandlungen {
		kosten = kosten + behandlung.GetKosten()
	}
	return kosten
}
