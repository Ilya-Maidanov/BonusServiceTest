import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {  // Рассчет для зарегистрированных пользователей и находящихся под лимитом
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;  // подготавливаем данные:
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual); // производим проверку (сравниваем ожидаемый и фактический):
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {  //  Рассчет для зарегистрированных пользователей и превышающих лимит
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;  // подготавливаем данные:
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual); // производим проверку (сравниваем ожидаемый и фактический):
    }

    @Test
    void shoutCalculateForUnregisteredAndUnderLimit(){  //  Рассчет для незарегистрированных пользователей и находящихся под лимитом
        BonusService service = new BonusService();

        long amount = 1_000;
        boolean registered = false; //Подготавливаем данные
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual); // Производим проверку
    }

    @Test
    void shoutCalculateForUnregisteredAndOverLimit(){ //  Рассчет для незарегистрированных пользователей и превышающих лимит
        BonusService service = new BonusService();

        long amount = 10_000_000;
        boolean registered = false; // Подготоваливаем данные
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual); // Производим проверку
    }
}
