INSERT INTO `comuni` (`id`, `nome`, `codice_catastale`, `provincia`, `cap`, `prefisso`, `mail`, `pec`, `telefono`, `fax`, `id_coordinata`) VALUES
(1, 'Roma', 'H501', '058', '00186', '06', 'ld.gabinetto@comune.roma.it', 'protocollo.segretariato@pec.comune.roma.it', '+39 06/67102001', '+39 06/67103590', 1),
(2, 'Milano', 'F205', '015', '20141', '02', 'stl.informagiovani@comune.milano.it', 'protocollo@postacert.comune.milano.it', '+39 02 0202', '+39 02 88452170', 2),
(3, 'Napoli', 'F839', '063', '80127', '081', 'sindaco@comune.napoli.it', 'protocollo@pec.comune.napoli.it', '+39 081 7951111', '+39 081 7955509', 3);

INSERT INTO `coordinate` (`id`, `lat`, `lng`) VALUES
(1, 41.8930549621582, 12.48277759552002),
(2, 45.46694564819336, 9.1899995803833),
(3, 40.83333206176758, 14.25);