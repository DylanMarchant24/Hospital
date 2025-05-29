package com.duoc.hospital.config;

import com.duoc.hospital.Model.*;
import com.duoc.hospital.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.duoc.hospital.Model.Estado;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataInitialization implements CommandLineRunner {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private PrevisionRepository previsionRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private AtencionRepository atencionRepository;

    @Override
    public void run(String... args) throws Exception {

        // Estados
        Estado estado_1 = new Estado("ALTA", "Paciente en estado libre para irse a casa");
        Estado estado_2 = new Estado("HOSPITALIZADO", "Paciente hospitalizado y en observación");
        Estado estado_3 = new Estado("PENDIENTE", "Paciente a espera de atención");

        if (estadoRepository.count() == 0) {
            estadoRepository.save(estado_1);
            estadoRepository.save(estado_2);
            estadoRepository.save(estado_3);
        }

        // Especialidades
        Especialidad especialidad_1 = new Especialidad("Medicina General", "Medicina general para toda la familia.");
        Especialidad especialidad_2 = new Especialidad("Pediatría", "Especialidad médica dedicada a niños y adolescentes.");
        Especialidad especialidad_3 = new Especialidad("Cardiología", "Diagnóstico y tratamiento de enfermedades del corazón.");
        Especialidad especialidad_4 = new Especialidad("Dermatología", "Diagnóstico y tratamiento de enfermedades de la piel.");

        if (especialidadRepository.count() == 0) {
            especialidadRepository.save(especialidad_1);
            especialidadRepository.save(especialidad_2);
            especialidadRepository.save(especialidad_3);
            especialidadRepository.save(especialidad_4);
        }

        // Previsiones
        Prevision prevision_1 = new Prevision("FONASA", 50);
        Prevision prevision_2 = new Prevision("ISAPRE", 60);

        if (previsionRepository.count() == 0) {
            previsionRepository.save(prevision_1);
            previsionRepository.save(prevision_2);
        }

        // Médicos
        Medico medico_1 = new Medico(
                "10418567-1", "Julio", "Perez",
                LocalDate.parse("2020-03-15"), 900000,
                "ju.perez@hospital.cl", "569845823", especialidad_1);

        Medico medico_2 = new Medico(
                "11345987-2", "Ana", "Morales",
                LocalDate.parse("2018-09-01"), 950000,
                "ana.morales@hospital.cl", "56987451236", especialidad_2);

        Medico medico_3 = new Medico(
                "12456879-5", "Carlos", "Rojas",
                LocalDate.parse("2019-06-10"), 910000,
                "carlos.rojas@hospital.cl", "56976548932", especialidad_4);

        Medico medico_4 = new Medico(
                "13579246-8", "Andrés", "González",
                LocalDate.parse("2017-01-10"), 980000,
                "andres.gonzalez@hospital.cl", "56912345678", especialidad_3);

        if (medicoRepository.count() == 0) {
            medicoRepository.save(medico_1);
            medicoRepository.save(medico_2);
            medicoRepository.save(medico_3);
            medicoRepository.save(medico_4);
        }

        // Pacientes
        Paciente paciente_1 = new Paciente("15123588-2", "María", "Sanchez",
                LocalDate.parse("1992-05-20"), "ma.sanchez@correo.cl", "586989652", prevision_1);

        Paciente paciente_2 = new Paciente("16111222-3", "Luis", "Gonzalez",
                LocalDate.parse("1985-11-12"), "lu.gonzalez@correo.cl", "598761234", prevision_2);

        Paciente paciente_3 = new Paciente("17222333-4", "Patricia", "Castro",
                LocalDate.parse("1990-08-30"), "pa.castro@correo.cl", "591234567", prevision_1);

        Paciente paciente_4 = new Paciente("18333444-5", "Jorge", "Ramirez",
                LocalDate.parse("1978-03-22"), "jo.ramirez@correo.cl", "587654321", prevision_2);

        Paciente paciente_5 = new Paciente("19444555-6", "Camila", "Torres",
                LocalDate.parse("2000-01-15"), "ca.torres@correo.cl", "599876543", prevision_1);

        if (pacienteRepository.count() == 0) {
            pacienteRepository.save(paciente_1);
            pacienteRepository.save(paciente_2);
            pacienteRepository.save(paciente_3);
            pacienteRepository.save(paciente_4);
            pacienteRepository.save(paciente_5);
        }

        // Atenciones
        Atencion atencion_1 = new Atencion(LocalDate.parse("2025-05-20"), LocalTime.parse("10:30:00"), 15000,
                "Paciente ingresa con dolor de cabeza", estado_1, paciente_1, medico_1);

        Atencion atencion_2 = new Atencion(LocalDate.parse("2025-05-20"), LocalTime.parse("11:00:00"), 18000,
                "Control pediátrico de rutina", estado_3, paciente_2, medico_2);

        Atencion atencion_3 = new Atencion(LocalDate.parse("2025-05-21"), LocalTime.parse("09:45:00"), 20000,
                "Consulta dermatológica por alergia", estado_2, paciente_3, medico_3);

        Atencion atencion_4 = new Atencion(LocalDate.parse("2025-05-21"), LocalTime.parse("12:15:00"), 22000,
                "Paciente consulta por taquicardia", estado_1, paciente_4, medico_1);

        Atencion atencion_5 = new Atencion(LocalDate.parse("2025-05-21"), LocalTime.parse("14:00:00"), 17000,
                "Revisión post-operatoria", estado_3, paciente_5, medico_2);

        Atencion atencion_6 = new Atencion(LocalDate.parse("2025-05-22"), LocalTime.parse("08:30:00"), 19000,
                "Paciente presenta infección cutánea", estado_2, paciente_1, medico_3);

        Atencion atencion_7 = new Atencion(LocalDate.parse("2025-05-22"), LocalTime.parse("10:00:00"), 21000,
                "Consulta por hipertensión", estado_1, paciente_2, medico_1);

        Atencion atencion_8 = new Atencion(LocalDate.parse("2025-05-23"), LocalTime.parse("11:30:00"), 16000,
                "Evaluación pediátrica por fiebre", estado_2, paciente_3, medico_2);

        Atencion atencion_9 = new Atencion(LocalDate.parse("2025-05-23"), LocalTime.parse("13:45:00"), 23000,
                "Paciente con dolor de pecho", estado_3, paciente_4, medico_1);

        Atencion atencion_10 = new Atencion(LocalDate.parse("2025-05-23"), LocalTime.parse("15:00:00"), 17500,
                "Consulta dermatológica preventiva", estado_1, paciente_5, medico_3);

        if (atencionRepository.count() == 0) {
            atencionRepository.save(atencion_1);
            atencionRepository.save(atencion_2);
            atencionRepository.save(atencion_3);
            atencionRepository.save(atencion_4);
            atencionRepository.save(atencion_5);
            atencionRepository.save(atencion_6);
            atencionRepository.save(atencion_7);
            atencionRepository.save(atencion_8);
            atencionRepository.save(atencion_9);
            atencionRepository.save(atencion_10);
        }
    }
}
