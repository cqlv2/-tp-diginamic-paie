/*insertion des donnees de cotisation*/
INSERT INTO cotisation (code, imposable, libelle, taux_patronal, taux_salarial) VALUES
('SP01', true, 'URSSAF CSG NON DEDUCTIBLE', null, 0.024000),
('SP02', true, 'URSSAF CRDS', null, 0.005000),
('EP01', false, 'URSSAF MALADIE - MATERNITE - INVALIDITE', 0.128000, 0.007500),
('EP02', false, 'URSSAF SOLIDARITE', 0.003000, null),
('EP03', false, 'URSSAF ACCIDENT DU TRAVAIL', 0.012000, null),
('EP04', false, 'URSSAF ALLOC. FAMILIALES', 0.054000, null),
('EP05', false, 'URSSAF ASS. VIEILLESSE PLAF.', 0.084000, 0.067500),
('EP06', false, 'URSSAF ASS. VIEILLESSE DEPLAF.', 0.016000, 0.001000),
('EP07', false, 'URSSAF FNAL', 0.001000, null),
('EP12', false, 'ASSEDIC Tr. A', 0.040000, 0.024000),
('EP14', false, 'ASSEDIC Tr. B', 0.040000, 0.024000),
('EP19', false, 'FONDS DE GARANTIE (AGS)', 0.003000, null),
('EP20', false, 'RETRAITE ARRCO NC T1', 0.045000, 0.030000),
('EP21', false, 'RETRAITE ARRCO NC T2', 0.012150, 0.081000),
('EP28', false, 'TAXE APPRENTISSAGE', 0.006800, null),
('EP37', false, 'CSG DEDUCTIBLE', null, 0.051000),
('EPR1', false, 'AGFF NC TRANCHE 1', 0.012000, 0.008000),
('EPR2', false, 'AGFF NC TRANCHE 2', 0.013000, 0.009000),
('E900', false, 'PREVOYANCE NON CADRE TA', 0.003700, 0.003700),
('E901', false, 'PREVOYANCE NON CADRE TB', 0.007320, 0.004880);

/*insertion des donnees d'entreprise*/
INSERT INTO entreprise (adresse, code_naf, denomination, siret, urssaf) VALUES
(null, '6202A', 'Dev Institut', '80966785000022', null),
(null, '6202A', 'Sopra-Steria', '5555555000022', null),
(null, '6202A', 'Capgemini', '6666665000022', null);

/*insertion des donnees de grade*/
INSERT INTO grade (code, nb_heures_base, taux_base) VALUES
('GRADE_A', 152,11),
('GRADE_B', 152,21),
('GRADE_C', 152,31);


/*insertion des donnees de profil de remuneration*/
INSERT INTO profil_remuneration (code) VALUES
('Technicien'),
('Cadre'),
('Stagiaire');

/*insertion des donnees de relation entre profil remuneration et cotisation*/
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id) VALUES
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 1),
(1, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(2, 10),
(2, 12),
(2, 13),
(2, 17),
(2, 19),
(2, 15),
(2, 16),
(2, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 1);

/*insertion des donnees de preiode*/
INSERT INTO periode (date_debut, date_fin) VALUES
('2019-01-01', '2019-01-31'),
('2019-02-01', '2019-02-28'),
('2019-03-01', '2019-03-31'),
('2019-04-01', '2019-04-30'),
('2019-05-01', '2019-05-31'),
('2019-06-01', '2019-06-30'),
('2019-07-01', '2019-07-31'),
('2019-08-01', '2019-08-31'),
('2019-09-01', '2019-09-30'),
('2019-10-01', '2019-10-31'),
('2019-11-01', '2019-11-30'),
('2019-12-01', '2019-12-31');
