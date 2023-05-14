
function addProductBoxx(id, name, price, imageUrl) {

  var box = document.createElement("div");
  box.classList.add("box");

  var link = document.createElement("a");
  link.setAttribute("id", id);
  link.setAttribute("href", "pages/produkt.html");
  link.setAttribute("onclick", "storeItemSelected(this.id)");

  var imgDiv = document.createElement("div");
  imgDiv.setAttribute("id", id + "Img");

  var img = document.createElement("img");
  img.setAttribute("src", imageUrl || "produkty/michael-c-ncK1abCfC90-unsplash%201.png");

  imgDiv.appendChild(img);

  link.appendChild(imgDiv);

  box.appendChild(link);

  var nameP = document.createElement("p");
  nameP.textContent = name;

  box.appendChild(nameP);

  var priceP = document.createElement("p");
  var priceB = document.createElement("b");
  priceB.textContent = price + " szt.";
  priceP.appendChild(priceB);

  box.appendChild(priceP);

  var addToCartP = document.createElement("button");
  addToCartP.textContent = "do koszyka";


  box.appendChild(addToCartP);

  document.getElementById("someElementId").appendChild(box);
}







  // tablica z adresami URL obrazków
  var imageUrls = ["img/pierwszezdj.jpg", "img/logo.jpg", "img/łapki.jpg"];

  // zmienna przechowująca aktualny indeks obrazka
  var currentImageIndex = 0;

  // elementy DOM
  var image = document.getElementById("image");
  var nextButton = document.getElementById("next-button");

  // funkcja aktualizująca obrazek na podstawie wartości currentImageIndex
  function updateImage() {
    image.setAttribute("src", imageUrls[currentImageIndex]);
  }

  // obsługa kliknięcia na przycisk "Next"
  nextButton.addEventListener("click", function() {
    currentImageIndex = (currentImageIndex + 1) % imageUrls.length;
    updateImage();
  });

  // ustawienie początkowego obrazka
  updateImage();