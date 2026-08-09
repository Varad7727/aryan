import { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [trips, setTrips] = useState([]);
  const [selectedTrip, setSelectedTrip] = useState(null);
  const [seats, setSeats] = useState([]);
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [userName, setUserName] = useState("");

  // Get all trips
  const getTrips = async () => {
    try {
      const response = await axios.get("http://localhost:8000/trip/all");

      setTrips(response.data.Data);
    } catch (error) {
      console.log(error);
    }
  };

  // Get seats of selected trip
  const getSeats = async (tripId) => {
    try {
      const response = await axios.get(`http://localhost:8000/seat/${tripId}`);


      setSeats(response.data.Data);
    } catch (error) {
      console.log(error);
    }
  };

  // Load trips when page opens
  useEffect(() => {
    getTrips();
  }, []);

  // Select trip
  const selectTrip = (trip) => {
    setSelectedTrip(trip);
    setSelectedSeats([]);

    getSeats(trip._id);
  };

  // Select / unselect seat
  const selectSeat = (seat) => {
    if (seat.status === "Booked") {
      return;
    }

    if (selectedSeats.includes(seat._id)) {
      setSelectedSeats(
        selectedSeats.filter((id) => id !== seat._id)
      );
    } else {
      setSelectedSeats([
        ...selectedSeats,
        seat._id,
      ]);
    }
  };

  // Book seats
  const bookSeats = async () => {
    if (!userName) {
      alert("Enter your name");
      return;
    }

    if (selectedSeats.length === 0) {
      alert("Select at least one seat");
      return;
    }

    try {
     const response = await axios.post(
  "http://localhost:8000/booking/create",
  {
    userName: userName,
    tripId: selectedTrip._id,
    seatIds: selectedSeats,
  }
);
      alert(response.data.Message);

      // Refresh seats after booking
      getSeats(selectedTrip._id);

      // Clear selected seats
      setSelectedSeats([]);

    }  catch (error) {
  console.log("BOOKING ERROR:", error);
  console.log("SERVER RESPONSE:", error.response?.data);

  alert(
    error.response?.data?.Message ||
    error.message ||
    "Booking failed"
  );
}
  };

  return (
    <div className="app">

      <h1>Ticket Booking Platform</h1>

      {/* Trips */}

      <h2>Available Trips</h2>

      <div className="trips">

        {trips.map((trip) => (
          <div className="trip-card" key={trip._id}>

            <h3>{trip.name}</h3>

            <p>
              {trip.source} → {trip.destination}
            </p>

            <p>₹{trip.price}</p>

            <p>Total Seats: {trip.totalSeats}</p>

            <button onClick={() => selectTrip(trip)}>
              Select Trip
            </button>

          </div>
        ))}

      </div>


      {/* Seats */}

      {selectedTrip && (
        <div className="seat-section">

          <h2>
            Select Seats - {selectedTrip.name}
          </h2>

          <p>
            {selectedTrip.source} → {selectedTrip.destination}
          </p>

          <div className="seats">

            {seats.map((seat) => (

              <button
                key={seat._id}
                onClick={() => selectSeat(seat)}
                className={
                  seat.status === "Booked"
                    ? "seat booked"
                    : selectedSeats.includes(seat._id)
                    ? "seat selected"
                    : "seat available"
                }
              >
                {seat.seatNumber}
              </button>

            ))}

          </div>


          {/* Booking */}

          <div className="booking">

            <input
              type="text"
              placeholder="Enter your name"
              value={userName}
              onChange={(e) =>
                setUserName(e.target.value)
              }
            />

            <p>
              Selected Seats: {selectedSeats.length}
            </p>

            <p>
              Total Amount: ₹
              {selectedSeats.length *
                selectedTrip.price}
            </p>

            <button onClick={bookSeats}>
              Book Seats
            </button>

          </div>

        </div>
      )}

    </div>
  );
}

export default App;