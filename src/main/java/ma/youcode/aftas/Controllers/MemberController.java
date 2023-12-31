package ma.youcode.aftas.Controllers;

import ma.youcode.aftas.Models.Dtos.MemberDto.MemberRequestDto;
import ma.youcode.aftas.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<MemberRequestDto> getAllMembers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return memberService.getAllMembers(page, size);
    }

    @GetMapping("/all")
    public Integer getAllMembers() {
        return memberService.CountAllMembers();
    }
    @GetMapping("/{id}")
    public MemberRequestDto getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping("/create")
    public MemberRequestDto createMember(@RequestBody MemberRequestDto memberDto) {
        return memberService.createMember(memberDto);
    }

    @PutMapping ("/update")
    public MemberRequestDto updateMember(@RequestBody MemberRequestDto memberDto){
        return memberService.updateMember(memberDto);
    }

    @DeleteMapping("/{id}")
    public void deleteMemberById(@PathVariable Long id){
        memberService.deleteById(id);
    }
}
