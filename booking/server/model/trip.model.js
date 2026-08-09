const mongoose = require("mongoose");
const tripschema = new mongoose.Schema(
  {
    name: {
      type: String,
      required: true,
    },
    source: {
      type: String,
      required: true,
    },
    destination: {
      type: String,
      required: true,
    },
    price: {
      type: Number,
      required: true,
    },
    date: {
      type: Date,
      required: true,
    },
    totalSeats: {
      type: Number,
      required: true,
    },
  },
  { timestamps: true },
);
const Trip = mongoose.model("Trip", tripschema);
module.exports = Trip;
