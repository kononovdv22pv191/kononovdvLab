package org.bank;

import org.bank.entity.*;
import org.bank.service.*;
import org.bank.service.impl.*;
import org.bank.utils.Status;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank(1, "ВТБ"));
        System.out.println(bank);


        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice(1, "Молодцы", "Ленина 1",
                bank, true, true, true, true, true,
                100000, 200));
        System.out.println(bankOffice);


        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.create(new Employee(1, "Иван", LocalDate.of(2001, 1, 1),
                        "Менеджер", true, bankOffice, true, 40000));
        System.out.println(employee);


        AtmService atmService = new AtmServiceImpl();
        BankAtm bankAtm = atmService.create(new BankAtm(1, "RPG", Status.WORK, true,
                true, 10000, 200, bankOffice));
        System.out.println(bankAtm);


        UserService userService = new UserServiceImpl();
        User user = userService.create(new User(1, "Олег", LocalDate.of(2001, 2,
                1), 9000, "Пушкина 2", bank));
        System.out.println(user);


        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(1, user, bank, 4000));
        System.out.println(paymentAccount);


        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(1, user, bank,
                LocalDate.of(2001, 2, 9), 4, 1000, employee, paymentAccount));
        System.out.println(creditAccount);

        System.out.println(bank);

    }
}