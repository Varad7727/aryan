const Booking = require("../model/booking.model");
const Sit = require("../model/sit.model");
const Trip = require("../model/trip.model");

//book seats
const createBookingController = async (req, res) => {
    try {
        //check
        const { userName, tripId, seatIds } = req.body;
        if (!userName || !tripId || !seatIds || seatIds.length === 0) {
            return res.status(400).json({
                Success: false,
                Message: "User, trip and seats are required",
            });
        }
        //find trip
        const trip = await Trip.findById(tripId);
        if (!trip) {
            return res.status(400).json({
                Success: false,
                Message: "No trip found",
            });
        }
        //find selected seats
        const findSeat = await Sit.find({
            _id: { $in: seatIds },
            tripId:tripId
        });
        //check existence
        if (findSeat.length !== seatIds.length) {
            return res.status(400).json({
                Success: false,
                Message: "Invalid seat selection",
            });
        }
        //check availability
        const unavailableSeats = findSeat.find(
            (sit) => sit.status === "Booked"
        );
        if (unavailableSeats) {
            return res.status(400).json({
                Success: false,
                Message: `Seat ${unavailableSeats.seatNumber} is already booked`,
            });
        }
        //amount
        const totalAmount = trip.price * seatIds.length;
        //trip came from above there we extracted from Trip

        //create booking
        const booking = await Booking.create({
            userName,
            tripId,
            seatIds,
            totalAmount,
        });
        // Mark selected seats as booked
        await Sit.updateMany(
            {
                _id: { $in: seatIds },
            },
            {
                $set: {
                    status: "Booked",
                },
            }
        );

        return res.status(201).json({
            Success: true,
            Message: "Seats booked successfully",
            Data: booking,
        });


    } catch (error) {
        return res.status(500).json({
            Success: false,
            Message: error.message,
        });
    }
}

module.exports={
    createBookingController
};