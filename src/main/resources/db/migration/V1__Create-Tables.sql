CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    email    VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(20)  NOT NULL,
    isAdmin  BOOLEAN DEFAULT FALSE
);

CREATE TABLE responsaveis
(
    id   BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf  VARCHAR(11)  NOT NULL
);

CREATE TABLE alunos
(
    id             BIGSERIAL PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    cpf            VARCHAR(11)  NOT NULL,
    responsavel_id BIGINT       NOT NULL,

    CONSTRAINT fk_responsavel FOREIGN KEY (responsavel_id) REFERENCES responsaveis (id)
);

CREATE TABLE tags
(
    id     BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100)
);

CREATE TABLE imagens
(
    id     BIGSERIAL PRIMARY KEY,
    imagem TEXT,
    data   TIMESTAMP
);

CREATE TABLE categorias
(
    id        BIGSERIAL PRIMARY KEY,
    titulo    VARCHAR(100),
    imagem_id BIGINT,

    CONSTRAINT fk_imagem FOREIGN KEY (imagem_id) REFERENCES imagens (id)
);

CREATE TABLE posts
(
    id           BIGSERIAL PRIMARY KEY,
    titulo       VARCHAR(100),
    descricao    TEXT,
    categoria_id BIGINT,
    imagem_id    BIGINT,

    CONSTRAINT fk_categoria FOREIGN KEY (categoria_id) REFERENCES categorias (id),
    CONSTRAINT fk_imagem FOREIGN KEY (imagem_id) REFERENCES imagens (id)
);

CREATE TABLE post_tags
(
    post_id BIGINT NOT NULL,
    tag_id  BIGINT NOT NULL,

    CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES posts(id),
    CONSTRAINT fk_tag FOREIGN KEY (tag_id) REFERENCES tags(id),
    PRIMARY KEY (post_id, tag_id)
);

CREATE TABLE post_imagens
(
    post_id  BIGINT NOT NULL,
    imagem_id BIGINT NOT NULL,

    CONSTRAINT fk_post FOREIGN KEY (post_id) REFERENCES posts(id),
    CONSTRAINT fk_imagem FOREIGN KEY (imagem_id) REFERENCES imagens(id),
    PRIMARY KEY (post_id, imagem_id)
);

CREATE TABLE controle_diario
(
    id           BIGSERIAL PRIMARY KEY,
    data         TIMESTAMP                                                          NOT NULL,
    aluno_id     BIGINT                                                             NOT NULL,
    lanche       VARCHAR(8) CHECK (lanche IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    almoco       VARCHAR(8) CHECK (almoco IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    lanche_tarde VARCHAR(8) CHECK (lanche_tarde IN ('ótimo', 'regular', 'recusei')) NOT NULL,
    jantar       VARCHAR(8) CHECK (jantar IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    mamadeira    VARCHAR(8) CHECK (mamadeira IN ('ótimo', 'regular', 'recusei'))    NOT NULL,
    mamadeira2   VARCHAR(8) CHECK (mamadeira2 IN ('ótimo', 'regular', 'recusei'))   NOT NULL,
    mamadeira3   VARCHAR(8) CHECK (mamadeira3 IN ('ótimo', 'regular', 'recusei'))   NOT NULL,
    evacuacao    VARCHAR(8) CHECK (evacuacao IN ('ótimo', 'regular', 'recusei'))    NOT NULL,
    xixi         BOOLEAN                                                            NOT NULL,
    banho        BOOLEAN                                                            NOT NULL,
    horario      TIME                                                               NOT NULL,
    dose         VARCHAR(255),
    febre        NUMERIC,
    nome         VARCHAR(255),
    titulo       VARCHAR(255),

    CONSTRAINT fk_aluno FOREIGN KEY (aluno_id) REFERENCES alunos(id)
)
