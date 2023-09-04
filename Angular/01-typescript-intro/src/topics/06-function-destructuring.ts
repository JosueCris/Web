interface Product {
    description: string,
    price: number
}

const phone: Product = {
    description: 'iPhone SE 2',
    price: 10499
}

const watch: Product = {
    description: 'Apple Watch Series 6',
    price: 8999
}


interface TaxCalculationOptions {
    tax: number,
    products: Product[];
}

function taxCalculation(options: TaxCalculationOptions): number[] {
    let total = 0;
    // options.products.forEach( product => {
    //     total += product.price;
    // });
    options.products.forEach(({ price })  => {
        total += price;
    });
    return [total, total*options.tax];
}


const shoppingCart = [phone, watch];
const tax = 0.15;

// const result = taxCalculation({
//     products: shoppingCart,
//     tax,
// });

const [total, taxResult] = taxCalculation({
    products: shoppingCart,
    tax,
});


console.log("Total: $" + total);
console.log("Tax: $" + taxResult);






export {}