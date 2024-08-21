CREATE TABLE users
(
    id             BIGSERIAL PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    email          VARCHAR(100) NOT NULL UNIQUE,
    senha          VARCHAR(255) NOT NULL,
    is_professor   BOOLEAN DEFAULT false,
    is_responsavel BOOLEAN DEFAULT false,
    is_admin       BOOLEAN DEFAULT false
);

CREATE TABLE professores
(
    id         BIGSERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    senha      VARCHAR(255) NOT NULL,
    id_usuario INT,

    CONSTRAINT fk_usuario_professor FOREIGN KEY (id_usuario) REFERENCES users (id)
);

CREATE TABLE responsaveis
(
    id         BIGSERIAL PRIMARY KEY,
    cpf        VARCHAR(11)  NOT NULL UNIQUE,
    nome       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    senha      VARCHAR(255) NOT NULL,
    id_usuario INT,

    CONSTRAINT fk_usuario_responsavel FOREIGN KEY (id_usuario) REFERENCES users (id)
);

CREATE TABLE admins
(
    id         BIGSERIAL PRIMARY KEY,
    nome       VARCHAR(100) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    senha      VARCHAR(255) NOT NULL,
    id_usuario INT,

    CONSTRAINT fk_usuario_admin FOREIGN KEY (id_usuario) REFERENCES users (id)
);

CREATE TABLE alunos
(
    id             BIGSERIAL PRIMARY KEY,
    nome           VARCHAR(100) NOT NULL,
    cpf            VARCHAR(11)  NOT NULL UNIQUE,
    responsavel_id BIGINT       NOT NULL,

    CONSTRAINT fk_responsavel FOREIGN KEY (responsavel_id) REFERENCES responsaveis (id)
);

CREATE TABLE salas
(
    id           BIGSERIAL PRIMARY KEY,
    nome         VARCHAR(100) NOT NULL,
    id_aluno     BIGINT,
    id_professor BIGINT,

    CONSTRAINT fk_alunos FOREIGN KEY (id_aluno) REFERENCES alunos (id),
    CONSTRAINT fk_professores FOREIGN KEY (id_professor) REFERENCES professores (id)
);

CREATE TABLE tags
(
    id     BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL
);

CREATE TABLE imagens
(
    id     BIGSERIAL PRIMARY KEY,
    imagem TEXT NOT NULL,
    data   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categorias
(
    id        BIGSERIAL PRIMARY KEY,
    titulo    VARCHAR(100) NOT NULL,
    imagem_id BIGINT,

    CONSTRAINT fk_imagem_categoria FOREIGN KEY (imagem_id) REFERENCES imagens (id)
);

CREATE TABLE posts
(
    id           BIGSERIAL PRIMARY KEY,
    titulo       VARCHAR(100) NOT NULL,
    descricao    TEXT,
    categoria_id BIGINT,
    imagem_id    BIGINT,

    CONSTRAINT fk_categoria_post FOREIGN KEY (categoria_id) REFERENCES categorias (id),
    CONSTRAINT fk_imagem_post FOREIGN KEY (imagem_id) REFERENCES imagens (id)
);

CREATE TABLE post_tags
(
    post_id BIGINT NOT NULL,
    tag_id  BIGINT NOT NULL,

    CONSTRAINT fk_post_tag_post FOREIGN KEY (post_id) REFERENCES posts (id),
    CONSTRAINT fk_post_tag_tag FOREIGN KEY (tag_id) REFERENCES tags (id),
    PRIMARY KEY (post_id, tag_id)
);

CREATE TABLE post_imagens
(
    post_id   BIGINT NOT NULL,
    imagem_id BIGINT NOT NULL,

    CONSTRAINT fk_post_imagem_post FOREIGN KEY (post_id) REFERENCES posts (id),
    CONSTRAINT fk_post_imagem_imagem FOREIGN KEY (imagem_id) REFERENCES imagens (id),
    PRIMARY KEY (post_id, imagem_id)
);

CREATE TABLE controle_diario
(
    id           BIGSERIAL PRIMARY KEY,
    data         TIMESTAMP                                                          NOT NULL DEFAULT CURRENT_TIMESTAMP,
    aluno_id     BIGINT                                                             NOT NULL,
    lanche       VARCHAR(7) CHECK (lanche IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    almoco       VARCHAR(7) CHECK (almoco IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    lanche_tarde VARCHAR(7) CHECK (lanche_tarde IN ('ótimo', 'regular', 'recusei')) NOT NULL,
    jantar       VARCHAR(7) CHECK (jantar IN ('ótimo', 'regular', 'recusei'))       NOT NULL,
    mamadeira    VARCHAR(7) CHECK (mamadeira IN ('ótimo', 'regular', 'recusei'))    NOT NULL,
    mamadeira2   VARCHAR(7) CHECK (mamadeira2 IN ('ótimo', 'regular', 'recusei'))   NOT NULL,
    mamadeira3   VARCHAR(7) CHECK (mamadeira3 IN ('ótimo', 'regular', 'recusei'))   NOT NULL,
    evacuacao    VARCHAR(7) CHECK (evacuacao IN ('ótimo', 'regular', 'recusei'))    NOT NULL,
    xixi         BOOLEAN                                                            NOT NULL,
    banho        BOOLEAN                                                            NOT NULL,
    horario      TIME                                                               NOT NULL,
    dose         VARCHAR(255),
    febre        NUMERIC,

    CONSTRAINT fk_controle_aluno FOREIGN KEY (aluno_id) REFERENCES alunos (id)
);