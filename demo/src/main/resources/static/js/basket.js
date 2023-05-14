var counter = 1;

function addProductBox(id, name, price, imageUrl) {
  var quantity = 1;
  var totalPrice = price;

  var productHTML = `
    <div class="cart-item">
      <img src="${imageUrl}" />
      <h4>${name}</h4>
      <p class="price">$<span id="price-${counter}" th:text="${totalPrice.toFixed(2)}">0.00</span></p>
      <div class="quantity">
        <button class="minus" onclick="updateQuantity(${counter}, -1, ${price.toFixed(2)})">-</button>
        <input type="text" id="quantity-${counter}" value="${quantity}" readonly>
        <button class="plus" onclick="updateQuantity(${counter}, 1, ${price.toFixed(2)})">+</button>
      </div>
      <button class="remove" onclick="removeProduct(this, ${counter})">&times;</button>
    </div>
  `;

  document.getElementById("someElementId").innerHTML += productHTML;

    var priceElement = document.getElementById(`price-${counter}`);
    priceElement.textContent = price.toFixed(2);
  counter++;

  calculateTotal();
}

function updateQuantity(counter, change, pricePerItem) {
  var quantityInput = document.getElementById(`quantity-${counter}`);
  var priceElement = document.getElementById(`price-${counter}`);

  var quantity = parseInt(quantityInput.value);
  var totalPrice = parseFloat(priceElement.textContent);

  quantity += change;
  totalPrice = quantity * pricePerItem;

  quantityInput.value = quantity;
  priceElement.textContent = totalPrice.toFixed(2);

  calculateTotal();
}

function removeProduct(button, counter) {
  var cartItem = button.parentNode;
  cartItem.remove();

  calculateTotal();
}

function calculateTotal() {
  var cartItems = document.querySelectorAll("#someElementId .cart-item");
  var totalValue = 0;

  for (var i = 0; i < cartItems.length; i++) {
    var priceElement = cartItems[i].querySelector(".price span");
    var price = parseFloat(priceElement.textContent);
    totalValue += price;
  }

  var totalValueElement = document.getElementById("total-value");
  totalValueElement.textContent = totalValue.toFixed(2);

  var deliveryCost = 20.00;
  var totalSum = totalValue + deliveryCost;
  var totalSumElement = document.getElementById("total-sum");
  totalSumElement.textContent = totalSum.toFixed(2);
}

// Wywołaj funkcję calculateTotal przy wczytaniu strony, aby początkowo obliczyć sumę
window.addEventListener("load", calculateTotal);
