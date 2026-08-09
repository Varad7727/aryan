const mongoose = require("mongoose");

// Schema for storing individual seats
const seatSchema = new mongoose.Schema(
  {
    // Stores the ID of the trip to which this seat belongs
    // Example: Seat A1 belongs to the Mumbai → Pune trip
    tripId: {
      type: mongoose.Schema.Types.ObjectId,

      // "Trip" refers to the Trip model we created earlier
      ref: "Trip",

      // Every seat must belong to a trip
      required: true,
    },

    // Stores the seat number
    // Example: A1, A2, A3, A4...
    seatNumber: {
      type: String,

      // Seat number is mandatory
      required: true,
    },

    // Stores whether the seat is currently available or booked
    status: {
      type: String,

      // Only these two values are allowed
      enum: ["Available", "Booked"],

      // When a new seat is created, it will initially be available
      default: "Available",
    },
  },

  // Automatically adds createdAt and updatedAt fields
  {
    timestamps: true,
  },
);

// Create the Seat model using the seatSchema
const Seat = mongoose.model("Seat", seatSchema);

// Export the Seat model so controllers can use it
module.exports = Seat;
