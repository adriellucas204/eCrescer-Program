import { calcular, OPERACAO_INVALIDA } from '../../src/calculadora'

describe('suite de testes calculadora', () => {
  it('Ao somar 5 e 2 deve retornar 7', () => {
    const resultadoEsperado = 7

    expect(calcular('soma', [5, 2])).toBe(resultadoEsperado)
  })

  it('Ao subtrair 2 de 100 deve retornar 98', () => {
    const resultadoEsperado = 98 

    expect(calcular('subtracao', [100, 2])).toBe(resultadoEsperado)
  })

  it('Ao multiplicar 100 por 10 deve retornar 1000', () => {
    const resultadoEsperado = 1000 

    expect(calcular('multiplicacao', [100, 10])).toBe(resultadoEsperado)
  })

  it('Ao dividir 45 por 9 deve retornar 5', () => {
    const resultadoEsperado = 5 

    expect(calcular('divisao', [45, 9])).toBe(resultadoEsperado)
  })

  it ('Ao passar uma operacao inválida deve retornar operaçao inválida', () => {
    const resultadoEsperado = OPERACAO_INVALIDA

    expect(calcular('nao sei fazer conta', [1, 3])).toBe(resultadoEsperado)
  })
})