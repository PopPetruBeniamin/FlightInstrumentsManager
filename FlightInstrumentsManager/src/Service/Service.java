package Service;

import Domain.SoftwareInstrument;
import Domain.HardwareInstrument;
import Repository.InMemoryRepository;

import java.util.List;

public class Service {
    private final InMemoryRepository<SoftwareInstrument> softwareInstrumentRepository;
    private final InMemoryRepository<HardwareInstrument> hardwareInstrumentRepository;

    public Service(InMemoryRepository<SoftwareInstrument> manuscriptRepository, InMemoryRepository<HardwareInstrument> presentationRepository) {
        this.softwareInstrumentRepository = manuscriptRepository;
        this.hardwareInstrumentRepository = presentationRepository;
    }

    //=======================SoftwareInstrument functions===========================

    public void addSoftwareInstrument(SoftwareInstrument softwareInstrument){
        softwareInstrumentRepository.add(softwareInstrument);
    }

    public List<SoftwareInstrument> getSoftwareInstruments(){
        return softwareInstrumentRepository.getAll();
    }

    //=======================HardwareInstrument functions===========================
    public void addHardwareInstrument(HardwareInstrument hardwareInstrument){
        hardwareInstrumentRepository.add(hardwareInstrument);
    }

    public List<HardwareInstrument> getAllHardwareInstruments(){
        return hardwareInstrumentRepository.getAll();
    }

}
