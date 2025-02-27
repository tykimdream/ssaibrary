package com.jjplanet.ssaibrary.seat.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjplanet.ssaibrary.room.domain.Room;
import com.jjplanet.ssaibrary.room.repository.RoomRepository;
import com.jjplanet.ssaibrary.seat.domain.Seat;
import com.jjplanet.ssaibrary.seat.dto.SeatDTO;
import com.jjplanet.ssaibrary.seat.repository.SeatRepository;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public void insertSeat(SeatDTO seatDTO) throws Exception {
		Room room = roomRepository.findOndById(seatDTO.getRoomId());
		Seat seat = new Seat(seatDTO.getId(), room, seatDTO.getPassword(), seatDTO.getStatus());
		seatRepository.save(seat);
	}

	@Override
	public void updateSeat(SeatDTO seatDTO) throws Exception {
		Seat updateSeat = seatRepository.findOndById(seatDTO.getId());
		Room room = roomRepository.findOndById(seatDTO.getRoomId());
		
		// if updateSeat == null

		updateSeat.setRoom(room);
		updateSeat.setPassword(seatDTO.getPassword());
		updateSeat.setStatus(seatDTO.getStatus());
		seatRepository.save(updateSeat);
	}

	@Override
	public List<SeatDTO> findAllSeat() throws Exception {
		List<Seat> seatList = seatRepository.findAll();
		List<SeatDTO> seatDTOList = new LinkedList<>();
		for (Seat s : seatList) {
			seatDTOList.add(new SeatDTO(s.getId(), s.getRoom().getId(), s.getPassword(), s.getStatus()));
		}
		return seatDTOList;
	}

	@Override
	public SeatDTO findSeatById(Long id) throws Exception {
		Seat seat = seatRepository.findOndById(id);
		SeatDTO seatDTO = new SeatDTO(seat.getId(), seat.getRoom().getId(), seat.getPassword(), seat.getStatus());
		return seatDTO;
	}

	@Override
	public void deleteSeat(Long id) throws Exception {
		seatRepository.deleteById(id);
	}
}
