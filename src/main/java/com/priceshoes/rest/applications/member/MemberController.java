package com.priceshoes.rest.applications.member;

import com.priceshoes.rest.applications.AbstractRestController;
import com.priceshoes.rest.applications.bean.MemberBean;
import com.priceshoes.rest.applications.entity.Member;
import com.priceshoes.rest.applications.exceptions.MemberCreationException;
import com.priceshoes.rest.applications.exceptions.MemberNotFoundException;
import com.priceshoes.rest.applications.hateoas.event.PaginatedResultsRetrievedEvent;
import com.priceshoes.rest.applications.hateoas.event.SingleResourceRetrievedEvent;
import com.priceshoes.rest.applications.respuesta.SocioRespuesta;
import com.priceshoes.rest.applications.service.MemberService;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({ "/member" })
public class MemberController extends AbstractRestController {
	private static final Class<MemberController> REST_CONTROLLER_NAME = MemberController.class;
	private static Logger log = Logger.getLogger(MemberController.class);
	@Autowired
	private MemberService memberService;
	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@RequestMapping(method = { RequestMethod.GET }, value = { "/hello" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> hello(@RequestParam(value = "name", defaultValue = "World") String name,
			HttpServletResponse httpServletResponse) {
		this.logger.debug("Start: /hello RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Request Param: %s value: %s", new Object[] { "name", name }));
		}

		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.hello(name, httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		body.put("data", String.format("Hello %s!", new Object[] { name }));
		body.put("_links", selfLink);
		this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		this.logger.debug("End: /hello RESTful Service");
		return ResponseEntity.ok(body);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/count" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> count(HttpServletResponse httpServletResponse) {
		this.logger.debug("Starting: /count RESTful Service");
		long count = this.memberService.count().longValue();
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(String.format("Number of records: %d", new Object[] { Long.valueOf(count) }));
		}

		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.count(httpServletResponse))
				.withSelfRel();
		HashMap data = new HashMap();
		data.put("data", Long.valueOf(count));
		data.put("_links", selfLink);
		this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
		this.logger.debug("Ending: /count RESTful Service");
		return ResponseEntity.ok(data);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> getMemberByEmailAddress(@RequestParam("emailAddress") String emailAddress,
			HttpServletResponse httpServletResponse) throws MemberNotFoundException {
		this.logger.debug("Starting: / RESTful Service");
		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.getMemberByEmailAddress(emailAddress, httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		Member member = this.memberService.findByMemberEmailAddress(emailAddress);
		if (null == member) {
			throw new MemberNotFoundException();
		} else {
			body.put("data", member);
			body.put("_links", selfLink);
			this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
			this.logger.debug("ending: / RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/{id}" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> getMemberById(@PathVariable("id") String id, HttpServletResponse httpServletResponse)
			throws MemberNotFoundException {
		this.logger.debug("Starting: /id RESTful Service");
		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.getMemberById(id, httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		Member member = this.memberService.findByMemberId(id);
		byte[] memberImage = this.memberService.getImage(id);
		if (null == member) {
			throw new MemberNotFoundException("Member Not Found for the Id:" + id);
		} else {
			body.put("data", member);
			body.put("_links", selfLink);
			body.put("image", memberImage);
			this.logger.debug("ending: /id RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/{id}/{dob}" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> getMemberByIdAndDOB(@PathVariable("id") String id, @PathVariable("dob") String dob,
			HttpServletResponse httpServletResponse) throws MemberNotFoundException, ParseException {
		this.logger.debug("Starting: id and dob RESTful Service");
		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.getMemberByIdAndDOB(id, dob, httpServletResponse))
				.withSelfRel();
		new HashMap();
		log.info(dob);
		Timestamp ts = Timestamp.valueOf(dob);
		Member member = this.memberService.findByMemberIdAndDOB(id, ts);
		SocioRespuesta respuesta = new SocioRespuesta();
		byte[] memberImage = this.memberService.getImage(id);
		if (null == member) {
			respuesta.setCodigo(500);
			respuesta.setMensaje("Member not found");
			throw new MemberNotFoundException();
		} else {
			respuesta.setSocio(member);
			respuesta.setSocioImage(memberImage);
			this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
			this.logger.debug("ending: id and dob RESTful Service");
			return new ResponseEntity(respuesta, HttpStatus.OK);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> findAll(HttpServletResponse httpServletResponse) throws MemberNotFoundException {
		this.logger.debug("Starting: / RESTful Service");
		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.findAll(httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		List memberList = (List) this.memberService.findAll();
		if (null == memberList) {
			throw new MemberNotFoundException();
		} else {
			if (!memberList.isEmpty()) {
				body.put("data", memberList);
				body.put("_links", selfLink);
				this.eventPublisher.publishEvent(new SingleResourceRetrievedEvent(this, httpServletResponse));
			}

			this.logger.debug("Ending: / RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/pages" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse httpServletResponse) throws MemberNotFoundException {
		this.logger.debug("Starting: /pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Size", Integer.valueOf(size) }));
		}

		HashMap body = new HashMap();
		Page memberPage = this.memberService.findAll(page, size);
		if (null == memberPage) {
			throw new MemberNotFoundException("Member Not Found");
		} else {
			if (memberPage.getNumber() != 0) {
				body.put("data", memberPage);
				this.eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent(Member.class, uriBuilder,
						httpServletResponse, page, memberPage.getTotalPages(), size));
			}

			this.logger.debug("Ending: /pages RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/inactives" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> findAllInactives(HttpServletResponse httpServletResponse) throws MemberNotFoundException {
		this.logger.debug("Starting: /inactives RESTful Service");
		Link selfLink = ControllerLinkBuilder
				.linkTo(((MemberController) ControllerLinkBuilder.methodOn(REST_CONTROLLER_NAME, new Object[0]))
						.findAllInactives(httpServletResponse))
				.withSelfRel();
		HashMap body = new HashMap();
		List memberList = (List) this.memberService.findAllInactiveMembers();
		if (null == memberList) {
			throw new MemberNotFoundException("Member Not Found");
		} else {
			if (!memberList.isEmpty()) {
				body.put("data", memberList);
				body.put("_links", selfLink);
				httpServletResponse.setHeader("_links", selfLink.toString());
			}

			this.logger.debug("Starting: /inactives RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/inactives/pages" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> findAllInactives(
			@RequestParam(value = "page", defaultValue = "1", required = false) int page,
			@RequestParam(value = "size", defaultValue = "10", required = false) int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse httpServletResponse) throws MemberNotFoundException {
		this.logger.debug("Starting: /inactives/pages RESTful Service");
		if (this.logger.isDebugEnabled()) {
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Page", Integer.valueOf(page) }));
			this.logger.debug(
					String.format("Request Parameter: %s value: %d", new Object[] { "Size", Integer.valueOf(size) }));
		}

		HashMap body = new HashMap();
		Page memberPage = this.memberService.findAllInactiveMembers(page, size);
		if (null == memberPage) {
			throw new MemberNotFoundException("Member Not Found");
		} else {
			if (memberPage.getNumber() != 0) {
				body.put("data", memberPage);
				this.eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent(Member.class, uriBuilder,
						httpServletResponse, page, memberPage.getTotalPages(), size));
			}

			this.logger.debug("Ending: /inactives/pages RESTful Service");
			return ResponseEntity.ok(body);
		}
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/getImage" })
	@ResponseBody
	public ResponseEntity<byte[]> getImage(@RequestParam("id") String id) throws IOException {
		byte[] image = this.memberService.getImage(id);
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(image));
		log.info(img);
		return new ResponseEntity(image, HttpStatus.OK);
	}

	@RequestMapping(method = { RequestMethod.GET }, value = { "/balance/{id}" })
	@ResponseBody
	public ResponseEntity<?> getBalance(@PathVariable("id") String id) {
		HashMap body = new HashMap();
		body.put("data", this.memberService.getBalance(id));
		return ResponseEntity.ok(body);
	}

	@RequestMapping(method = { RequestMethod.POST }, value = { "/createMember" }, produces = { "application/json",
			"application/xml" })
	@ResponseBody
	public ResponseEntity<?> createCustomer(@RequestBody MemberBean memberBean)
			throws IOException, MemberCreationException {
		SocioRespuesta respuesta = this.memberService.saveMember(memberBean);
		log.info("============MemberBean=============");
		log.info("MemberBean:" + memberBean.getSocio().getNombre());
		return ResponseEntity.ok(respuesta);
	}
}