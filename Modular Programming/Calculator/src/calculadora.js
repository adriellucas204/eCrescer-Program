export const OPERACAO_INVALIDA = 'OPERACAO_INVALIDA'

export const calcular = (operacao, valores) => {
  let valor = valores[0];
  if (operacao == "soma") {
    for (let i = 1; i < valores.length; i++){
      valor += valores[i];
    }
  }

  else if (operacao == "subtracao") {
    for (let i = 1; i < valores.length; i++) {
      valor -= valores[i];
    }
  }

  else if (operacao == "multiplicacao") {
    for (let i = 1; i < valores.length; i++) {
      valor *= valores[i];
    }
  }

  else if (operacao == "divisao") {
    for (let i = 1; i < valores.length; i++) {
      valor /= valores[i];
    }
  }
  else {
    return OPERACAO_INVALIDA;
  }

  return valor;
}
