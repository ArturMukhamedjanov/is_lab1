package islab1.mappers;

import javax.persistence.EntityNotFoundException;

import islab1.models.json.VenueJson;
import org.springframework.stereotype.Component;

import islab1.exceptions.ConvertionException;
import islab1.models.DTO.VenueDTO;
import islab1.models.Venue;
import islab1.models.auth.User;
import islab1.repos.UserRepo;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VenueMapper {

    private final UserRepo userRepo;
    
    public Venue toEntity(VenueDTO dto) throws ConvertionException {
        try{
            User creator = userRepo.getReferenceById(dto.getCreatorId());
            Venue venue = new Venue();
            venue.setCreator(creator);
            venue.setName(dto.getName());
            venue.setCapacity(dto.getCapacity());
            venue.setType(dto.getType());
            return venue;
        } catch (ConvertionException e) {
            throw e;
        } catch(EntityNotFoundException e){
            throw new ConvertionException(e.getMessage());
        }
    }

    public VenueDTO toDto(Venue venue) {
        VenueDTO dto = new VenueDTO();
        dto.setId(venue.getId());
        dto.setCreatorId(venue.getCreator().getId()); 
        dto.setName(venue.getName());
        dto.setCapacity(venue.getCapacity());
        dto.setType(venue.getType());
        return dto;
    }

    public Venue fromJson(VenueJson json) throws ConvertionException {
        Venue venue = new Venue();
        venue.setName(json.getName());
        venue.setCapacity(json.getCapacity());
        venue.setType(json.getType());
        return venue;
    }

}
