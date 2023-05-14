
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
const images = [
  {src: 'img/pierwszezdj.png', alt: 'Pierwsze zdjęcie', text: 'Wiosna w pełni! Kup róże w naszym sklepie i otrzymaj gratis zestaw nawozów do roślin, który uchroni Twoje róże przed chorobami'},
  {src: 'img/dwa.png', alt: 'Drugie zdjęcie', text: 'Rozpocznij swoją przygodę z ogrodnictwem! Kup nasiona marchewki i otrzymaj darmową poradę ogrodniczą od naszych ekspertów'},
  {src: 'img/trzy.png', alt: 'Trzecie zdjęcie', text: 'Posadź zdrowie! Kup nasiona marchewki w naszym sklepie z rabatem 10% dzięki kodowi MARCH10'}
];

const imageContainer = document.getElementById('image-container');
const imageElement = document.getElementById('image');
const imageTextElement = document.getElementById('image-text');
const nextButton = document.getElementById('next-btn');

let currentIndex = 0;

nextButton.addEventListener('click', () => {
  currentIndex = (currentIndex + 1) % images.length;
  const { src, alt, text } = images[currentIndex];
  imageElement.src = src;
  imageElement.alt = alt;
  imageTextElement.textContent = text;
});
