var images = [
    '../imagem/1.jpg',
    '../imagem/2.jpg',
    '../imagem/3.jpg'
  ];
  
  var index = 0;
  var backgroundImages = document.getElementById('background-images');
  
  setInterval(function() {
    index = (index + 1) % images.length;
    backgroundImages.style.backgroundImage = 'url(' + images[index] + ')';
  }, 5000); // troca a imagem a cada 5 segundos

  $(document).ready(function() {
    $('#myCarousel').carousel({
      interval: 1000 // tempo de transição em milissegundos
    })
  });


  