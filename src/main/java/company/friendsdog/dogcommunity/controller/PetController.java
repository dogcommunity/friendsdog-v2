package company.friendsdog.dogcommunity.controller;

import company.friendsdog.dogcommunity.dto.PetProfileModifyRequestDTO;
import company.friendsdog.dogcommunity.dto.response.PetCardResponseDTO;
import company.friendsdog.dogcommunity.entity.Pet;
import company.friendsdog.dogcommunity.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pet")
@Slf4j
public class PetController {

    // 펫 프로필 기입
    @GetMapping("/profile")
    public String petCard(){
        log.info("GET");
        return "/main/profile";
    }

    private final PetService petService;

    // 이웃 펫 찾기
    @GetMapping("/neighbor")
    public String findingNeighbor(Model model
//            , HttpSession session
    ) {
//        session=null;
        log.info("/petprofile/list : GET");


        List<PetCardResponseDTO> neighborList = petService.findingNeighbor(null);


        model.addAttribute("petList",neighborList);

        return "/pet/neighbor";
    }

    @PostMapping("/delete")
    public String delete(Long petNo) {
        log.info("/pet/delete : POST");
        petService.delete(petNo);
        return "redirect:/pet/list";

    }

    //프로필 조회 요청

    @GetMapping("/detail")
    public Pet detail(Long petNo){

        Pet pet = petService.getDetail(petNo);
        //pet
        return pet;
    }


    @GetMapping ("/modify") // 수정 폼 을 열어주는애
                                // 페이지 이동
                            // db에서 업데이트를 할려면 뭐가 필요한지
    public String modifyData(int petNo, Model model) {

//        // true / false 여부
//        boolean flag = petService.modify(dto);

        String hashTag = petService.getDetail((long) petNo).getHashtag();

        model.addAttribute("petNo", petNo);
        model.addAttribute("hashTag", hashTag);

        log.info("petNo : {} ", petNo);

        return "pet/profileMod";
    }

    @PostMapping("/modify") //수정 폼안에 있는 데이터를 보내주는애
    public String modifyData(PetProfileModifyRequestDTO dto, Model model) {

        // true / false 여부
        boolean flag = petService.modify(dto);

        model.addAttribute("petNo", dto.getPetNo());
        model.addAttribute("hashTag", dto.getHashTag());

//       어디로 리던 할꺼임 ??????>
        return "pet/profileMod";
    }


}
