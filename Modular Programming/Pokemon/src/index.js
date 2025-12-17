// inicie por aqui
import { listaPokemons } from "./listaPoke";

// const treinador = {
//     nome: null,
//     idade: null,
//     pokemonsCapturados: null
// }

export function criarTreinador(nome, idade, pokemonInicialId) {
    let pokemon = procurarPokemon(pokemonInicialId);
    const treinador = {
        nome,
        idade,
        pokemonsCapturados: [{...pokemon, level:pokemon.levelInicial}]
    };
    return treinador;
}


export function procurarPokemon(pokemonId) {
    return listaPokemons.find(pokemon => pokemon.id == pokemonId);
}

export function capturarPokemon(treinador, pokemonId) {
    const novoTreinador = Object.assign({}, treinador);
    let pokemons = treinador.pokemonsCapturados;
    pokemons = pokemons.map(pokemon => {
        pokemon.level++;
        if (pokemon.level == pokemon.evolucao.level)
            pokemon = {...pokemon, ...procurarPokemon(pokemon.evolucao.id)};
        return pokemon;
    })

    let pokemonCapturado = procurarPokemon(pokemonId);
    pokemons.push({...pokemonCapturado, level: pokemonCapturado.levelInicial});
    novoTreinador.pokemonsCapturados = pokemons;

    return novoTreinador;
}
