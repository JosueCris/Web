const skills: string[] = ['Bash', 'Counter', 'Healing']; // Si sabemos que no cambiara el valor de la variable la dejamos en constante


// Las interfaces en JS/TS es el equivalente a los structs, se declaran las variables y el tipo (Clases tontas (sin metodos)).
interface Character {
    name: string;
    hp: number;
    skills: string[];
    hometown?: string;  // El signo indica que la propiedad es opcional que este presente en la variable del tipo de la interface
}

const strider: Character = {
    name: 'Strider',
    hp: 100,
    skills: ['Bash', 'Counter']
};

strider.hometown = 'Rivendell';

console.table(strider);

export {}