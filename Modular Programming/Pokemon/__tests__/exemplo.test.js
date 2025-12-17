import {criarTreinador, procurarPokemon, capturarPokemon } from '../src/index'


describe('Exemplo de testes', () => {
  it('Deve subir o nível do pokemon corretamente', () => {
    let treinador = criarTreinador("Adriel", 14, "2");
    treinador = capturarPokemon(treinador, 5);
    
    expect(treinador.pokemonsCapturados[0].level).toBe(6);
  })

  it('Deve evoluir pokemon ao atingir o nível necessário', () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    
    expect(treinador.pokemonsCapturados[0].id).toBe(2);
  })

  it('Não deve evoluir pokemon caso não possua o level necessário', () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    treinador = capturarPokemon(treinador, 1);
    
    expect(treinador.pokemonsCapturados[0].id).toBe(1);
  })

  it("Treinador será criado com nome correto", () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    const nomeEsperado = "Adriel";
    
    expect(treinador.nome).toBe(nomeEsperado);
  })

  it("Treinador será criado com a idade correta", () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    const idadeEsperada = 14;
    
    expect(treinador.idade).toBe(idadeEsperada);
  })

  it("Treinador será criado com o pokemon inicial correto", () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    const pokemonIdEsperado = 1;
    
    expect(treinador.pokemonsCapturados[0].id).toBe(pokemonIdEsperado);
  })

  it("Treinador terá seus pokemons atualizados após nova captura", () => {
    let treinador = criarTreinador("Adriel", 14, "1");
    treinador = capturarPokemon(treinador, 5);
    const quantPokemonsEsperada = 2;
    
    expect(treinador.pokemonsCapturados.length).toBe(quantPokemonsEsperada);
  })
})