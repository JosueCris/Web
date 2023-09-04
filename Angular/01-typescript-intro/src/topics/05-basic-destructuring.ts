// DESESTRUCTURACION DE OBJETOS
interface AudioPlayer {
    audioVolume: number,
    songDuration: number,
    song: string,
    details: Details
}

interface Details {
    author: string,
    year: number
}


const audioPlayer: AudioPlayer = {
    audioVolume: 90,
    songDuration: 36,
    song: 'Mess',
    details: {
        author: 'Ed Sheeran',
        year: 2015
    }
}

const { song, 
        audioVolume: volume, 
        songDuration: duration,
        details
    } = audioPlayer;

const { author } = details;

// console.log("Cancion: " + audioPlayer.song);
// console.log("Cancion: " + song);
// console.log("Autor: " + audioPlayer.details.author);
// console.log("Duracion: " + duration);
// console.log("Author: " + author);




// DESESTRUCTURACION DE ARREGLOS
const dbz: string[] = ['Goku', 'Vegeta', 'Trunks'];

const [g, v, trunks] = dbz
// const [, , trunks] = dbz

console.log("Personaje: " + dbz[2]);
console.log("P1: " + g);
console.log("P2: " + v);
console.error("Desestructurado: " + trunks);

export {}