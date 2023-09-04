interface SuperHero {
    name: string,
    age: number,
    address: Address,
    showAddress: () => string
}

interface Address {
    street: string,
    country: string,
    city: string
}


const superHeroe: SuperHero = {
    name: 'Spiderman',
    age: 30,
    address: {
        street: 'Main st.',
        country: 'USA',
        city: 'New York'
    },
    showAddress() {
        return this.name + ', ' + this.address.city + ', ' + this.address.country;
    }
}


const address = superHeroe.showAddress();
console.log(address);



export {}