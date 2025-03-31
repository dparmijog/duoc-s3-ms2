package com.example.demo.repository;

import com.example.demo.models.Detail;
import com.example.demo.models.Invoice;
import com.github.f4b6a3.ulid.UlidCreator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class InvoicesRepository {

    private static final List<Invoice> invoices = List.of(
            new Invoice(
                    "VET-2024-001",
                    "A12345678",
                    "VetCare Barcelona",
                    "B87654321",
                    "Juan Martínez",
                    "Thor",
                    "Labrador retriever, macho, 5 años",
                    "2024-01-15",
                    List.of(
                            new Detail(createId(), "Consulta preventiva", BigDecimal.valueOf(15000)),
                            new Detail(createId(), "Vacuna polivalente",BigDecimal.valueOf(35000)),
                            new Detail(createId(), "Chip identificativo", BigDecimal.valueOf(25.00))
                    )
            ),
            new Invoice("VET-2024-002",
                    "B98765432",
                    "Animal Clinic Madrid",
                    "X1234567A",
                    "Sofía Ramírez",
                    "Misi",
                    "Gato europeo, hembra, 2 años",
                    "2024-02-20",
                    List.of(
                            new Detail(createId(), "Analítica prequirúrgica", BigDecimal.valueOf(65000)),
                            new Detail(createId(), "Castración", BigDecimal.valueOf(120000)),
                            new Detail(createId(), "Collar isabelino", BigDecimal.valueOf(15500))
                    )
            ),
            new Invoice(
                    "VET-2024-003",
                    "C56789123",
                    "Pet Emergency Valencia",
                    "Y7654321B",
                    "Carlos Fernández",
                    "Rocky",
                    "Bulldog francés, macho, 4 años",
                    "2024-03-05",
                    List.of(
                            new Detail(createId(), "Visita de urgencia",BigDecimal.valueOf( 75000)),
                            new Detail(createId(), "Radiografía", BigDecimal.valueOf(90000)),
                            new Detail(createId(), "Medicación antiinflamatoria", BigDecimal.valueOf(22800))
                    )
            )

);

    private static String createId() {
        return UlidCreator.getUlid().toLowerCase();
    }

    public static List<Invoice> getAll() {
        return invoices;
    }



    public static Optional<Invoice> getOneById(String id) {
        return invoices.stream()
                .filter(invoice -> invoice.getId().equals(id))
                .findFirst();
    }

    public static Optional<Invoice> getAny() {
        int index = new Random().nextInt(invoices.size());
        return Optional.of(invoices.get(index));
    }
}
