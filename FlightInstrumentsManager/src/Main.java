import Config.SettingsManager;
import Domain.SoftwareInstrument;
import Domain.SoftwareInstrumentConverter;
import Domain.HardwareInstrument;
import Domain.HardwareInstrumentConverter;
import Repository.InMemoryRepository;
import Repository.RepositoryFactory;
import Service.Service;
import Ui.Ui;


public class Main {
    public static void main(String[] args) {
        // Charging settings from a settings file
        SettingsManager settings = new SettingsManager("src\\Config\\settings.properties");

        // Creating the Repository factory
        RepositoryFactory factory = new RepositoryFactory(settings);

        // Instantiation the Repository
        InMemoryRepository<SoftwareInstrument> softwareRepository = factory.createRepository("SoftwareInstruments", new SoftwareInstrumentConverter());
        InMemoryRepository<HardwareInstrument> hardwareRepository = factory.createRepository("HardwareInstruments", new HardwareInstrumentConverter());

        if(softwareRepository.getAll().isEmpty()) {
            SoftwareInstrument s1 = new SoftwareInstrument("0001", true, 1);
            SoftwareInstrument s2 = new SoftwareInstrument("0002", true, 2);
            softwareRepository.add(s1);
            softwareRepository.add(s2);
        }

        if(hardwareRepository.getAll().isEmpty()) {
            HardwareInstrument h1 = new HardwareInstrument("0001", true, "altitudine");
            HardwareInstrument h2 = new HardwareInstrument("0002", true, "directie");
            hardwareRepository.add(h1);
            hardwareRepository.add(h2);
        }

        // Creating service and user interface
        Service manuscriptPresentationService = new Service(softwareRepository, hardwareRepository);

        Ui ui = new Ui(manuscriptPresentationService);

        // Start the user interface
        ui.start();
    }
}