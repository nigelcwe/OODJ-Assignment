import application.entities.GymSystem;

import java.time.LocalDateTime;

public class BackendTests {
    public static void main(String[] args) throws Exception {
        GymSystem gym = new GymSystem();
        gym.getReport().generateReport(LocalDateTime.now());
    }
}
