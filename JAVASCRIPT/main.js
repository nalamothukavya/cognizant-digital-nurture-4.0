console.log("Welcome to the Community Portal");

document.addEventListener("DOMContentLoaded", () => {
  alert("Page is fully loaded");

  const events = [
    { name: "Music Fest", date: "2025-08-01", seats: 10, category: "Music" },
    { name: "Art Workshop", date: "2025-06-10", seats: 0, category: "Art" },
    { name: "Tech Talk", date: "2025-07-15", seats: 5, category: "Tech" }
  ];

  const eventList = document.getElementById("event-list");
  const select = document.querySelector("select[name='eventSelect']");

  function displayEvents() {
    eventList.innerHTML = "";
    events.forEach((event, index) => {
      if (new Date(event.date) > new Date() && event.seats > 0) {
        const card = document.createElement("div");
        card.className = "event-card";
        card.innerHTML = \`
          <h3>\${event.name}</h3>
          <p>Date: \${event.date}</p>
          <p>Seats Left: \${event.seats}</p>
          <button onclick="registerEvent(\${index})">Register</button>
        \`;
        eventList.appendChild(card);

        const option = document.createElement("option");
        option.value = index;
        option.textContent = event.name;
        select.appendChild(option);
      }
    });
  }

  displayEvents();

  window.registerEvent = function(index) {
    try {
      if (events[index].seats > 0) {
        events[index].seats--;
        alert("Registered successfully!");
        displayEvents();
      } else {
        throw new Error("No seats left!");
      }
    } catch (e) {
      console.error(e.message);
    }
  };

  document.getElementById("registrationForm").addEventListener("submit", async function(e) {
    e.preventDefault();
    const name = this.elements.name.value;
    const email = this.elements.email.value;
    const eventIndex = this.elements.eventSelect.value;

    if (!name || !email) {
      alert("Please fill all fields.");
      return;
    }

    try {
      const response = await fetch("https://jsonplaceholder.typicode.com/posts", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, event: events[eventIndex].name })
      });
      const data = await response.json();
      console.log("Registration successful:", data);
      alert("Registration submitted!");
    } catch (error) {
      console.error("Submission failed", error);
    }
  });
});
