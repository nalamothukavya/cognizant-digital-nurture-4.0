function handleSubmit(event) {
  event.preventDefault();
  document.getElementById('confirmationMsg').innerText = "Registered successfully!";
}

function validatePhone(val) {
  if (!/^\d{10}$/.test(val)) alert("Invalid phone number");
}

function countChars(text) {
  document.getElementById("charCount").innerText = text.length + " chars";
}

function readyToPlay() {
  alert("Video ready to play!");
}

function findLocation() {
  navigator.geolocation.getCurrentPosition(
    (position) => {
      document.getElementById("locationResult").innerText =
        "Latitude: " + position.coords.latitude + ", Longitude: " + position.coords.longitude;
    },
    (error) => {
      alert("Error getting location: " + error.message);
    },
    { enableHighAccuracy: true, timeout: 5000 }
  );
}

function savePreference() {
  let type = document.getElementById("eventType").value;
  localStorage.setItem("preferredEvent", type);
}

function clearPrefs() {
  localStorage.clear();
  sessionStorage.clear();
}

window.onload = function () {
  let saved = localStorage.getItem("preferredEvent");
  if (saved) document.getElementById("eventType").value = saved;
};

window.onbeforeunload = function () {
  return "Are you sure you want to leave this page?";
};
