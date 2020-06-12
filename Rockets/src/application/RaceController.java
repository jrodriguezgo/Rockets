package application;

import application.dto.CircuitDTO;
import domain.Circuit;
import persistence.RaceRepository;

public class RaceController {
	
	public CircuitDTO createCircuit(CircuitDTO circuitDTO) throws Exception {
		Circuit circuit = new Circuit(circuitDTO);
		RaceRepository.storeCircuit(circuit);
		return new CircuitDTO(circuit);

	}
	
	public CircuitDTO getCircuit(String circuitID) throws Exception {
		Circuit circuit = RaceRepository.getCircuit(circuitID);
		return new CircuitDTO (circuit);
	}

	public CircuitDTO updateCircuit(String id, CircuitDTO circuitDTO) throws Exception {
		Circuit circuit  = RaceRepository.getCircuit(id);
		circuit.updateCircuit(circuitDTO);
		RaceRepository.updateCircuit(circuit);
		return new CircuitDTO(circuit);
	}

}
