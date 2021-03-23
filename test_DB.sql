--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.2

-- Started on 2021-03-23 21:39:07

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 16503)
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    id integer NOT NULL,
    lastname character varying(30) NOT NULL,
    firstname character varying(30) NOT NULL
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16501)
-- Name: customers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_id_seq OWNER TO postgres;

--
-- TOC entry 3004 (class 0 OID 0)
-- Dependencies: 200
-- Name: customers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;


--
-- TOC entry 202 (class 1259 OID 16509)
-- Name: goods; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.goods (
    good character varying(30) NOT NULL,
    price money NOT NULL
);


ALTER TABLE public.goods OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16514)
-- Name: sales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sales (
    customerid integer,
    date date NOT NULL,
    good character varying(30) NOT NULL
);


ALTER TABLE public.sales OWNER TO postgres;

--
-- TOC entry 2858 (class 2604 OID 16506)
-- Name: customers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);


--
-- TOC entry 2996 (class 0 OID 16503)
-- Dependencies: 201
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customers (id, lastname, firstname) VALUES (17, 'Иванов', 'Иван');
INSERT INTO public.customers (id, lastname, firstname) VALUES (18, 'Петров', 'Петр');
INSERT INTO public.customers (id, lastname, firstname) VALUES (19, 'Игорев', 'Игорь');
INSERT INTO public.customers (id, lastname, firstname) VALUES (20, 'Семенов', 'Семен');
INSERT INTO public.customers (id, lastname, firstname) VALUES (21, 'Иванов', 'Изекиль');
INSERT INTO public.customers (id, lastname, firstname) VALUES (22, 'Иванов', 'Гарвель');
INSERT INTO public.customers (id, lastname, firstname) VALUES (23, 'Петров', 'Натаниэль');
INSERT INTO public.customers (id, lastname, firstname) VALUES (24, 'Петров', 'Вальдор');


--
-- TOC entry 2997 (class 0 OID 16509)
-- Dependencies: 202
-- Data for Name: goods; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.goods (good, price) VALUES ('мясо', '$350.00');
INSERT INTO public.goods (good, price) VALUES ('рис', '$49.00');
INSERT INTO public.goods (good, price) VALUES ('макаронныеизделия', '$74.00');
INSERT INTO public.goods (good, price) VALUES ('яйца', '$87.00');
INSERT INTO public.goods (good, price) VALUES ('овощи', '$200.00');
INSERT INTO public.goods (good, price) VALUES ('газировка', '$110.00');
INSERT INTO public.goods (good, price) VALUES ('молоко', '$67.00');
INSERT INTO public.goods (good, price) VALUES ('сыр', '$230.00');
INSERT INTO public.goods (good, price) VALUES ('шоколад', '$93.00');
INSERT INTO public.goods (good, price) VALUES ('минеральнаявода', '$52.00');
INSERT INTO public.goods (good, price) VALUES ('творог', '$81.00');


--
-- TOC entry 2998 (class 0 OID 16514)
-- Dependencies: 203
-- Data for Name: sales; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-01-11', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-02-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-02-01', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-01', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-01', 'молоко');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-16', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-16', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-16', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-03-28', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-04-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-04-01', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-05-02', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-05-02', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (17, '2020-05-02', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'молоко');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-01-21', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-02-13', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-02-13', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-02-13', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-02-13', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'яйца');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-03-05', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-04-03', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-05-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-05-01', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-05-01', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (18, '2020-05-01', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-04-18', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-04-30', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-04-30', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (19, '2020-05-06', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-01', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-09', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-17', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-28', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-28', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-01-28', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-02-04', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-02-16', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-02-28', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-07', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-19', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-25', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-31', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-31', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (20, '2020-03-31', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'макаронныеизделия');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'овощи');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (21, '2020-03-04', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-03-04', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-03-04', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-03-04', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-05-24', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-05-24', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-05-24', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-06-17', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-06-17', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (22, '2020-06-17', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-01-09', 'молоко');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'минеральнаявода');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'газировка');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'творог');
INSERT INTO public.sales (customerid, date, good) VALUES (23, '2020-03-19', 'молоко');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-01-09', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'мясо');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'сыр');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'рис');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'шоколад');
INSERT INTO public.sales (customerid, date, good) VALUES (24, '2020-03-19', 'шоколад');


--
-- TOC entry 3005 (class 0 OID 0)
-- Dependencies: 200
-- Name: customers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_id_seq', 24, true);


--
-- TOC entry 2860 (class 2606 OID 16508)
-- Name: customers customers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);


--
-- TOC entry 2862 (class 2606 OID 16513)
-- Name: goods goods_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (good);


--
-- TOC entry 2863 (class 2606 OID 16517)
-- Name: sales sales_customerid_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_customerid_fkey FOREIGN KEY (customerid) REFERENCES public.customers(id);


--
-- TOC entry 2864 (class 2606 OID 16522)
-- Name: sales sales_good_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_good_fkey FOREIGN KEY (good) REFERENCES public.goods(good);


-- Completed on 2021-03-23 21:39:09

--
-- PostgreSQL database dump complete
--

