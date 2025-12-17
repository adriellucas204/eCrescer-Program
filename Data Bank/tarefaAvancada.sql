-- 1. Liste o total de proprietários (físicos e jurídicos) que possuem simultaneamente imóveis
-- e veículos. Exibir apenas o total de propriedades conforme o tipo de pessoa
select p.tipo_proprietario, count(distinct p.id)
from proprietario p
	inner join proprietario_imovel pi on
	pi.proprietario_id = p.id
	inner join proprietario_veiculo pv on
	pv.proprietario_id = p.id
group by p.tipo_proprietario;


-- 2. Exiba os imóveis com área construída maior que a média geral,
-- a área construída ocupa
-- mais de 75% do terreno e não seja imóvel Rural.
select id, tipo_imovel, tipo_habitacao,
area_construida, area_terreno, cidade
from imovel
where area_construida > (
	select AVG(area_construida) from imovel
)
and tipo_imovel not in ('Rural')
and area_construida > 0.75 * area_terreno
group by id;


-- 3. Liste as pessoas que possuem mais de um tipo de relação com outras pessoas (usando
-- pessoa_relacao e COUNT(DISTINCT tipo_relacao)).
select p.id, p.nome, p.sobrenome from pessoa p
	inner join pessoa_relacao pr on pr.pessoa_id = p.id 
group by p.id, p.nome, p.sobrenome
having count(distinct pr.tipo_relacao) > 1;


-- 4. Liste os nomes das pessoas e o total de telefones que possuem
-- (usando proprietario_telefone), listando quem tem mais telefones primeiro.
select p.id, p.nome, count(pt.telefone_id) as total_telefones from pessoa p
	inner join proprietario_pessoa_fisica pf on pf.pessoa_id = p.id
	inner join proprietario_telefone pt on pt.proprietario_id = pf.proprietario_id
	inner join telefone t on t.id = pt.telefone_id
group by p.id, p.nome
order by total_telefones desc;


-- 5. Liste os nomes das empresas com seus proprietários, exibindo o nome da empresa,
-- nome e sobrenome do proprietario, e participação. Ordene por empresa e data de
-- abertura.
select emp.nome as Empresa, 
pe.proprietario_id, p.nome || ' ' || p.sobrenome
as nome_e_sobrenome,
pe.participacao
from empresa emp
	inner join proprietario_empresa pe
	on pe.empresa_id = emp.id
	inner join proprietario_pessoa_fisica ppf
	on ppf.proprietario_id = pe.proprietario_id
	inner join pessoa p
	on p.id = ppf.pessoa_id
order by emp.id,
emp.data_abertura;
