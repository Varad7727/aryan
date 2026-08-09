const mongoose = require("mongoose");
const bookingSchema = new mongoose.Schema(
  {
    userName: {
      type: String,
      required: true,
    },
    tripId: {
      type: mongoose.Schema.Types.ObjectId,
      ref: "Trip",
      required: true,
    },
    seatIds: [
      {
        type: mongoose.Schema.Types.ObjectId,
        ref: "Sit",
      },
    ],
    totalAmount: {
      type: Number,
      required: true,
    },
    status: {
      type: String,
      enum: ["Confirmed", "Cancelled"],
      default: "Confirmed",
    },
  },
  { timestamps: true },
);
const Booking = mongoose.model("Booking", bookingSchema);

module.exports = Booking;

//Why seatIds is an array?
//Because one booking can contain multiple seats.