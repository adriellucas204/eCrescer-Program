-- 1. Liste o nome e apelido das pessoas junto com as
-- características de cabelo e altura (JOIN com pessoa_caracteristica).
select nome, apelido, cor_cabelo,
formato_cabelo, altura
from pessoa p
	inner join pessoa_caracteristica pc on pc.pessoa_id = p.id

-- 2. Mostre o total de veículos cadastrados por ano.
select ano, count(ano) from veiculo
group by ano
order by ano asc;

-- 3. Liste os nomes das cidades e quantos bairros estão registrados em
-- cada uma.
select c.nome, count(b.id) as numero_bairros from cidade c
	inner join bairro b on b.cidade_id = c.id
	group by c.nome
	order by numero_bairros asc;

-- 4. Liste os nomes das pessoas e o total de telefones que possuem
-- (usando proprietario_telefone). Podem considerar apenas pessoas físicas.
select p.id, p.nome, count(pt.telefone_id) as total_telefones from pessoa p
	inner join proprietario_pessoa_fisica pf on pf.pessoa_id = p.id
	inner join proprietario_telefone pt on pt.proprietario_id = pf.proprietario_id
	inner join telefone t on t.id = pt.telefone_id
group by p.id, p.nome
order by total_telefones desc;

-- 5. Mostre os veículos e seus modelos.
-- (Todos os dados do veículo, nome e fabricante do modelo)
select v.id, v.modelo_id, v.cor, v.ano, v.placa,
mv.nome, mv.fabricante from veiculo v
	inner join modelo_veiculo mv on mv.id = v.modelo_id
