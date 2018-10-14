--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.10
-- Dumped by pg_dump version 9.6.10

-- Started on 2018-10-14 23:16:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 187 (class 1259 OID 16507)
-- Name: screen_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screen_entity (
    id bigint NOT NULL,
    screen_name character varying(255)
);


ALTER TABLE public.screen_entity OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16505)
-- Name: screen_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.screen_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.screen_entity_id_seq OWNER TO postgres;

--
-- TOC entry 2155 (class 0 OID 0)
-- Dependencies: 186
-- Name: screen_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.screen_entity_id_seq OWNED BY public.screen_entity.id;


--
-- TOC entry 189 (class 1259 OID 16515)
-- Name: screen_info_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.screen_info_entity (
    id bigint NOT NULL,
    number_of_seats bigint,
    row_name character varying(255),
    screen_id bigint NOT NULL
);


ALTER TABLE public.screen_info_entity OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16513)
-- Name: screen_info_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.screen_info_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.screen_info_entity_id_seq OWNER TO postgres;

--
-- TOC entry 2156 (class 0 OID 0)
-- Dependencies: 188
-- Name: screen_info_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.screen_info_entity_id_seq OWNED BY public.screen_info_entity.id;


--
-- TOC entry 191 (class 1259 OID 16523)
-- Name: seat_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seat_entity (
    id bigint NOT NULL,
    aisle_seat character varying(255),
    already_booked character varying(255),
    seat_number bigint,
    row_id bigint NOT NULL
);


ALTER TABLE public.seat_entity OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 16521)
-- Name: seat_entity_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seat_entity_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seat_entity_id_seq OWNER TO postgres;

--
-- TOC entry 2157 (class 0 OID 0)
-- Dependencies: 190
-- Name: seat_entity_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.seat_entity_id_seq OWNED BY public.seat_entity.id;


--
-- TOC entry 2015 (class 2604 OID 16510)
-- Name: screen_entity id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_entity ALTER COLUMN id SET DEFAULT nextval('public.screen_entity_id_seq'::regclass);


--
-- TOC entry 2016 (class 2604 OID 16518)
-- Name: screen_info_entity id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_info_entity ALTER COLUMN id SET DEFAULT nextval('public.screen_info_entity_id_seq'::regclass);


--
-- TOC entry 2017 (class 2604 OID 16526)
-- Name: seat_entity id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seat_entity ALTER COLUMN id SET DEFAULT nextval('public.seat_entity_id_seq'::regclass);


--
-- TOC entry 2144 (class 0 OID 16507)
-- Dependencies: 187
-- Data for Name: screen_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.screen_entity VALUES (1, 'inox');


--
-- TOC entry 2158 (class 0 OID 0)
-- Dependencies: 186
-- Name: screen_entity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.screen_entity_id_seq', 1, true);


--
-- TOC entry 2146 (class 0 OID 16515)
-- Dependencies: 189
-- Data for Name: screen_info_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.screen_info_entity VALUES (1, 10, 'A', 1);
INSERT INTO public.screen_info_entity VALUES (2, 15, 'B', 1);
INSERT INTO public.screen_info_entity VALUES (3, 20, 'D', 1);


--
-- TOC entry 2159 (class 0 OID 0)
-- Dependencies: 188
-- Name: screen_info_entity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.screen_info_entity_id_seq', 3, true);


--
-- TOC entry 2148 (class 0 OID 16523)
-- Dependencies: 191
-- Data for Name: seat_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.seat_entity VALUES (1, 'yes', 'no', 0, 1);
INSERT INTO public.seat_entity VALUES (2, 'no', 'no', 1, 1);
INSERT INTO public.seat_entity VALUES (3, 'no', 'no', 2, 1);
INSERT INTO public.seat_entity VALUES (4, 'no', 'no', 3, 1);
INSERT INTO public.seat_entity VALUES (5, 'no', 'no', 4, 1);
INSERT INTO public.seat_entity VALUES (6, 'yes', 'no', 5, 1);
INSERT INTO public.seat_entity VALUES (7, 'yes', 'no', 6, 1);
INSERT INTO public.seat_entity VALUES (8, 'no', 'no', 7, 1);
INSERT INTO public.seat_entity VALUES (9, 'no', 'no', 8, 1);
INSERT INTO public.seat_entity VALUES (10, 'yes', 'no', 9, 1);
INSERT INTO public.seat_entity VALUES (17, 'yes', 'no', 6, 2);
INSERT INTO public.seat_entity VALUES (18, 'no', 'no', 7, 2);
INSERT INTO public.seat_entity VALUES (19, 'no', 'no', 8, 2);
INSERT INTO public.seat_entity VALUES (20, 'yes', 'no', 9, 2);
INSERT INTO public.seat_entity VALUES (21, 'no', 'no', 10, 2);
INSERT INTO public.seat_entity VALUES (22, 'no', 'no', 11, 2);
INSERT INTO public.seat_entity VALUES (23, 'no', 'no', 12, 2);
INSERT INTO public.seat_entity VALUES (24, 'no', 'no', 13, 2);
INSERT INTO public.seat_entity VALUES (25, 'no', 'no', 14, 2);
INSERT INTO public.seat_entity VALUES (32, 'yes', 'no', 6, 3);
INSERT INTO public.seat_entity VALUES (33, 'no', 'no', 7, 3);
INSERT INTO public.seat_entity VALUES (34, 'no', 'no', 8, 3);
INSERT INTO public.seat_entity VALUES (35, 'yes', 'no', 9, 3);
INSERT INTO public.seat_entity VALUES (36, 'no', 'no', 10, 3);
INSERT INTO public.seat_entity VALUES (37, 'no', 'no', 11, 3);
INSERT INTO public.seat_entity VALUES (38, 'no', 'no', 12, 3);
INSERT INTO public.seat_entity VALUES (39, 'no', 'no', 13, 3);
INSERT INTO public.seat_entity VALUES (40, 'no', 'no', 14, 3);
INSERT INTO public.seat_entity VALUES (41, 'no', 'no', 15, 3);
INSERT INTO public.seat_entity VALUES (42, 'no', 'no', 16, 3);
INSERT INTO public.seat_entity VALUES (43, 'no', 'no', 17, 3);
INSERT INTO public.seat_entity VALUES (44, 'no', 'no', 18, 3);
INSERT INTO public.seat_entity VALUES (45, 'no', 'no', 19, 3);
INSERT INTO public.seat_entity VALUES (12, 'no', 'yes', 1, 2);
INSERT INTO public.seat_entity VALUES (13, 'no', 'yes', 2, 2);
INSERT INTO public.seat_entity VALUES (14, 'no', 'yes', 3, 2);
INSERT INTO public.seat_entity VALUES (16, 'yes', 'yes', 5, 2);
INSERT INTO public.seat_entity VALUES (15, 'no', 'yes', 4, 2);
INSERT INTO public.seat_entity VALUES (11, 'yes', 'yes', 0, 2);
INSERT INTO public.seat_entity VALUES (26, 'yes', 'yes', 0, 3);
INSERT INTO public.seat_entity VALUES (27, 'no', 'yes', 1, 3);
INSERT INTO public.seat_entity VALUES (28, 'no', 'yes', 2, 3);
INSERT INTO public.seat_entity VALUES (29, 'no', 'yes', 3, 3);
INSERT INTO public.seat_entity VALUES (30, 'no', 'yes', 4, 3);
INSERT INTO public.seat_entity VALUES (31, 'yes', 'yes', 5, 3);


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 190
-- Name: seat_entity_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seat_entity_id_seq', 45, true);


--
-- TOC entry 2019 (class 2606 OID 16512)
-- Name: screen_entity screen_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_entity
    ADD CONSTRAINT screen_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 2021 (class 2606 OID 16520)
-- Name: screen_info_entity screen_info_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_info_entity
    ADD CONSTRAINT screen_info_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 2023 (class 2606 OID 16531)
-- Name: seat_entity seat_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seat_entity
    ADD CONSTRAINT seat_entity_pkey PRIMARY KEY (id);


--
-- TOC entry 2024 (class 2606 OID 16532)
-- Name: screen_info_entity fkkl24ekclmymje38ohj6d1kc0c; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.screen_info_entity
    ADD CONSTRAINT fkkl24ekclmymje38ohj6d1kc0c FOREIGN KEY (screen_id) REFERENCES public.screen_entity(id);


--
-- TOC entry 2025 (class 2606 OID 16537)
-- Name: seat_entity fkqrt24r5v6sblan17jktdptkv8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seat_entity
    ADD CONSTRAINT fkqrt24r5v6sblan17jktdptkv8 FOREIGN KEY (row_id) REFERENCES public.screen_info_entity(id);


-- Completed on 2018-10-14 23:16:19

--
-- PostgreSQL database dump complete
--

