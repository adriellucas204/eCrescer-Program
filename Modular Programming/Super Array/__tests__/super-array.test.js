import instrutores from './instrutores.json'
import { SuperArray } from '../src/super-array'

describe('SuperArray - Testes obrigatórios', () => {

  let array;

  beforeEach(() => {
    array = SuperArray(instrutores);
  });

  it('push deve adicionar um novo instrutor ao meu super array', () => {
    const novo = { nome: "Novo Instrutor", dandoAula: false };
    array.push(novo);

    expect(array.length()).toBe(instrutores.length + 1);
    expect(array.itens[array.length() - 1]).toEqual(novo);
  });

  it('forEach deve passar por todos os instrutores e chamando o callback esperado', () => {
    const mockCallback = jest.fn();
    array.forEach(mockCallback);
    expect(mockCallback).toHaveBeenCalledTimes(instrutores.length);
  });

  it('filter deve retornar um novo array apenas com os instrutores que estão dando aula', () => {
    const filtrados = array.filter(i => i.dandoAula === true);
    const esperado = instrutores.filter(i => i.dandoAula);
    expect(filtrados.itens).toEqual(esperado);
  });

  it('map deve retornar um novo array com o numero de nomes que o instrutor tem', () => {
    const mapeado = array.map(i => i.nome.split(" ").length);
    const esperado = instrutores.map(i => i.nome.split(" ").length);
    expect(mapeado.itens).toEqual(esperado);
  });

  it('reduce deve retornar o total de letras no nome dos instrutores', () => {
    const total = array.reduce(
      (acc, item) => acc + item.nome.replace(/ /g, "").length,
      0
    );
    const esperado = instrutores.reduce(
      (acc, item) => acc + item.nome.replace(/ /g, "").length,
      0
    );
    expect(total).toBe(esperado);
  });

  it('reduce deve retornar um boolean se todos os instrutores estão dando aula', () => {
    const todos = array.reduce((acc, item) => acc && item.dandoAula, true);
    const esperado = instrutores.every(i => i.dandoAula);
    expect(todos).toBe(esperado);
  });

  it('find deve retornar o primeiro instrutor que está dando aula', () => {
  const encontrado = array.find(i => i.dandoAula === true);
  const esperado = instrutores.find(i => i.dandoAula === true);
  expect(encontrado).toEqual(esperado);
});

});