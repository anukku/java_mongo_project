// products.js

document.addEventListener("DOMContentLoaded", function () {
    // Fetch products and update the product list
    fetch('/product/getAll')
        .then(response => response.json())
        .then(products => {
            const productListDiv = document.getElementById('productList');
            products.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.innerHTML = `
                    <h2>${product.description}</h2>
                    <p>Price: $${product.price}</p>
                    <p>Size: ${product.size}</p>
                    <img src="data:image/jpeg;base64,${product.image}" alt="${product.description}" width="200"/>
                `;
                productListDiv.appendChild(productDiv);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
});
