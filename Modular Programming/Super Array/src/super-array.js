export const SuperArray = (itens = []) => {

  const array = {
    /**
     * Propriedade para acessar os itens
     */

    itens: [...itens],
  }

  // criei uma funcao que retorna o tamanho do array
  array.length = () => {
    let tamanho = 0;
    while (array.itens[tamanho] != undefined) {
      tamanho++;
    }
    return tamanho;
  }

  /**
   * Adicionar um novo item ao final dos items
   */

  array.push = item => {
    let tamanho = array.length();

    array.itens[tamanho] = item;
  }

  /**
   * Itera sobre cada um dos elementos do SuperArray enviando o item e o index
   * como segundo parametro
   */

  array.forEach = callback => {
    for (let i = 0; i < array.length(); i++) {
      callback(array.itens[i]);
    }
  }

  /**
   * Retorna um novo SuperArray com os itens mapeados
   */

  array.map = callback => {
    let tempArray = SuperArray([]);
    
    for (let i = 0; i < array.length(); i++) {
      tempArray.push(callback(array.itens[i]));
    }

    return SuperArray(tempArray.itens);
  }


  /**
   * Retorna um SuperArray novo com os itens filtrados
   */

  array.filter = callback => {
    let tempArray = SuperArray([]);

    for (let i = 0; i < array.length(); i++) {
      if (callback(array.itens[i]))
        tempArray.push(array.itens[i]);
    }
    return SuperArray(tempArray.itens);
  }


  /**
   * Retorna o primeiro elemento do SuperArray que satisfazer o callback recebido
   * se não encontrar, deve retornar undefined
   */

  array.find = callback => {
    for (let i = 0; i < array.length(); i++) {
      if (callback(array.itens[i]))
        return array.itens[i];
    }
    return undefined;
  }

  /**
   * Reduz o SuperArray em um único valor
   */


  array.reduce = (callback, valorInicial) => {
    let acumulador = valorInicial;
    let indexIni = 0;

    if (acumulador == undefined) {
      acumulador = array.itens[0];
      indexIni = 1;
    }

    for (let i = indexIni; i < array.length(); i++) {
      acumulador = callback(acumulador, array.itens[i]);
    }

    return acumulador;
  }

  return array
}
