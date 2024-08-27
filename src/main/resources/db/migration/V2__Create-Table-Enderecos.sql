CREATE TABLE enderecos
(
    id             BIGSERIAL PRIMARY KEY,
    logradouro     VARCHAR(255),
    numero         VARCHAR(10),
    bairro         VARCHAR(100),
    cidade         VARCHAR(100),
    estado         VARCHAR(2)

);

ALTER TABLE responsaveis
    ADD COLUMN endereco_id BIGINT UNIQUE,

    ADD CONSTRAINT fk_endereco FOREIGN KEY (endereco_id) REFERENCES enderecos (id) ON DELETE SET NULL;
