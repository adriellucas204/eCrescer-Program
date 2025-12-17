-- 1. Mostre os nomes e profissões das pessoas cadastradas. 
select nome, profissao
from pessoa

-- 2. Selecione os veículos fabricados a partir do ano 2020.
select *
from veiculo
where ano >= 2020;

-- 3. Exiba todos os modelos de veículos do tipo "automovel".
select *
from modelo_veiculo
where tipo = 'automovel';

-- 4. Liste quantas diferentes profissões estão cadastradas na base
select distinct profissao
from pessoa;

-- 5. Exiba todos os imóveis que têm mais de 100 m² de área construída.
select *
from imovel
where area_construida > 100;
