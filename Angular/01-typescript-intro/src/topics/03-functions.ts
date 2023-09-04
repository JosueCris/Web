// Desarrollo de la funcion normal
// function addNumbers(a: number, b: number): number {
//     return a + b;
// }

// // Expresion lambda
// const suma = (a:number, b: number): string => {
//     return `${a + b}`;
// }

/*  No marcar como tal un error poner un argumento obligatorio despues de uno opcional, pero de preferencia
    pongamos los opcionales al final */
// function multiply(firstNumber: number, base: number, secondNumber?: number): string {
//     return `${firstNumber * base}`;
// }

// const result1: number = addNumbers(1, 2);
// const result2: string = suma(3, 4);
// const result3: string = multiply(5, 6, 7);

// console.log({result1, result2, result3});




interface Character {
    name: string,
    hp: number,
    shopHp: () => void
}


const healCharacter = ( character: Character, amount: number ) => {
    character.hp += amount;
}


const strinder: Character = {
    name: 'Strinder',
    hp: 50,
    shopHp() {
        console.log(`LP: ${this.hp}`);
    }
}


healCharacter(strinder, 10);
healCharacter(strinder, 50);

strinder.shopHp();


export {}