CREATE TABLE `coordinate` (
  `id` int(11) NOT NULL,
  `lat` double NOT NULL,
  `lng` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `coordinate`
--

INSERT INTO `coordinate` (`id`, `lat`, `lng`) VALUES
(1, 41.8930549621582, 12.48277759552002),
(2, 45.46694564819336, 9.1899995803833),
(3, 40.83333206176758, 14.25);