package application;

import application.dto.RocketDTO;
import domain.Rocket;
import persistence.RocketRepository;

public class RocketController {
	
	public RocketDTO createRocket(RocketDTO rocketDTO) throws Exception {
		Rocket rocket = new Rocket(rocketDTO);
		RocketRepository.storeRocket(rocket);
		return new RocketDTO(rocket);

	}
	
	public RocketDTO getRocket(String rocketID) throws Exception {
		Rocket rocket = RocketRepository.getRocket(rocketID);
		return new RocketDTO (rocket);
	}

	public RocketDTO updateRocket(String id, RocketDTO rocketDTO) throws Exception {
		Rocket rocket  = RocketRepository.getRocket(id);
		rocket.updateRockets(rocketDTO);
		RocketRepository.updateRocket(rocket);
		return new RocketDTO(rocket);
	}

}
