    package com.example.sigeapi.model;

    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import lombok.Getter;
    import lombok.Setter;

    import java.io.Serializable;

    @Entity
    @Getter
    @Setter
    public class Vagas implements Serializable {
        @Id
        public Integer id;
        public int numero;
        public boolean status;
    }
